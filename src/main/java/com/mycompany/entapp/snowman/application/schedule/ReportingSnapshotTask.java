/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.schedule;

import com.mycompany.entapp.snowman.application.schedule.service.ReportingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class ReportingSnapshotTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportingSnapshotTask.class);

    @Autowired
    private ReportingService reportingService;

    public void executeTask() {
        LOGGER.info(reportingService.retrieveReportingData().toString());
    }
}
