/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.schedule.service.impl;

import com.mycompany.entapp.snowman.application.schedule.ReportingData;
import com.mycompany.entapp.snowman.application.schedule.service.ReportingService;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import com.mycompany.entapp.snowman.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    // TODO project service & employee service

    @Override
    public ReportingData retrieveReportingData() {
        // TODO
        return null;
    }
}
