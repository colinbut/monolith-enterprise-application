/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain;

import com.mycompany.entapp.snowman.domain.model.Project;
import org.joda.time.DateTime;

public final class ProjectTestHelper {

    private ProjectTestHelper(){
    }

    public static Project getProject() {
        Project project = new Project();
        project.setId(1);
        project.setProjectTitle("Project");
        project.setDateStarted(new DateTime(2018,1,1,12,0,0).toDate());
        project.setDateEnded(new DateTime(2020,1,1,12,0,0).toDate());
        return project;
    }
}
