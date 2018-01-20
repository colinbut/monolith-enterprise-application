/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.healthcheck;

public enum HealthStatus {
    UP("UP"),
    DOWN("DOWN");

    HealthStatus(String statusString){
        this.statusString = statusString;
    }

    private String statusString;

    public String getStatusString() {
        return statusString;
    }
}
