/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao.impl;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ProjectDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Override
    public Project retrieveProject(int projectId) {
        return null;
    }

    @Override
    public void saveProject(Project project) {

    }

    @Override
    public void removeProject(int projectId) {

    }
}
