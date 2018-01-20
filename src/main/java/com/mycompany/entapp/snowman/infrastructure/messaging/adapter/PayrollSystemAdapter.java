/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.PayrollSystemPort;

public class PayrollSystemAdapter implements PayrollSystemPort {
    @Override
    public void sendEmployeeInfo() {
        throw new RuntimeException("Not Yet Implemented");
    }
}
