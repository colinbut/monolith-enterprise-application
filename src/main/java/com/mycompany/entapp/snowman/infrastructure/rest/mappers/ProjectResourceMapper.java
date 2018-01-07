/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import com.mycompany.entapp.snowman.domain.model.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ProjectResourceMapper {

    private ProjectResourceMapper(){
    }

    public static Project mapToProject(ProjectResource projectResource) {
        Project project = new Project();
        project.setId(projectResource.getProjectId());
        project.setProjectTitle(projectResource.getTitle());
        project.setDateStarted(projectResource.getDateStarted());
        project.setDateEnded(projectResource.getDateEnded());
        //project.setClient
        return project;
    }

    public static ProjectResource mapToProjectResource(Project project) {
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProjectId(project.getId());
        projectResource.setTitle(project.getProjectTitle());
        projectResource.setDateStarted(project.getDateStarted());
        projectResource.setDateEnded(project.getDateEnded());
        return projectResource;
    }

    public static Set<Project> mapToProjects(List<ProjectResource> projectResources) {
        Set<Project> projects = new HashSet<>();
        for (ProjectResource projectResource : projectResources) {
            projects.add(mapToProject(projectResource));
        }
        return projects;
    }

    public static List<ProjectResource> mapToProjectResources(Set<Project> projects) {
        List<ProjectResource> projectResources = new ArrayList<>();
        for (Project project : projects) {
            projectResources.add(mapToProjectResource(project));
        }
        return projectResources;
    }
}
