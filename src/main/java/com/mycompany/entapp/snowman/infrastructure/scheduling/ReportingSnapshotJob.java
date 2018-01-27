/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.scheduling;

import com.mycompany.entapp.snowman.application.schedule.ReportingSnapshotTask;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class ReportingSnapshotJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportingSnapshotTask.class);

    private ReportingSnapshotTask reportingSnapshotTask;

    @Autowired
    public void setReportingSnapshotTask(ReportingSnapshotTask reportingSnapshotTask) {
        this.reportingSnapshotTask = reportingSnapshotTask;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("Running Quartz Scheduled task " + jobExecutionContext.getJobInstance().toString());
        reportingSnapshotTask.executeTask();
    }
}
