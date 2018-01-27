/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao;

import com.mycompany.entapp.snowman.domain.model.Project;

public interface ProjectDao {
    Project retrieveProject(int projectId);
    void saveProject(Project project);
    void removeProject(int projectId);
}
