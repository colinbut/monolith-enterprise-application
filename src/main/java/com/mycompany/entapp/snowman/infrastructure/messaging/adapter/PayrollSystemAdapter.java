/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.PayrollSystemPort;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class PayrollSystemAdapter implements PayrollSystemPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollSystemAdapter.class);

    private static final long MESSAGE_EXPIRATION_IN_MS = 5000L; // 5secs

    @Autowired
    @Qualifier("payrollJmsTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public void sendEmployeeInfo(final EmployeeDTO employeeDTO) {

        LOGGER.info("Sending Employee Info {} to external Payroll system", employeeDTO);

        // Flatten the Object here - external Payroll system does not expect an Object
        jmsTemplate.convertAndSend(employeeDTO, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setJMSCorrelationID("EmployeeId-" + employeeDTO.getId());

                // Don't care if external system doesn't get message
                // Payroll system at the moment can't handle that much payroll processing at once
                // So worst case, missed payments at end of month for employees
                // i.e. we can always pay them later, next month, haha!
                // or Account/HR Department could process payroll it manually
                message.setBooleanProperty("pristine", true);
                message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
                message.setJMSMessageID("123-0000-" + employeeDTO.getId());
                message.setJMSPriority(1);
                message.setJMSExpiration(MESSAGE_EXPIRATION_IN_MS);

                return message;
            }
        });
    }
}
