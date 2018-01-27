/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.Project;

public interface ProjectRepository {
    Project findProject(int projectId);
    void saveProject(Project project);
    void removeProject(int projectId);
}
