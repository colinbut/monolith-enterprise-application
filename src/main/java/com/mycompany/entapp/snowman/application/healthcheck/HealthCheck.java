/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.healthcheck;

import com.mycompany.entapp.snowman.infrastructure.db.health.DBHealthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck {

    @Autowired
    private DBHealthCheck dbHealthCheck;

    public HealthStatus getHealthStatus() {
        return (dbHealthCheck.getDBStatus()) ? HealthStatus.UP : HealthStatus.DOWN;
    }
}
