/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.service.ProjectService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.ProjectResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectRestEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRestEndpoint.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/{projectId}")
    public ResponseEntity<ProjectResource> getProject(@PathVariable Integer projectId) {
        Project project = projectService.getProject(projectId);
        ProjectResource projectResource = ProjectResourceMapper.mapToProjectResource(project);
        return ResponseEntity.ok(projectResource);
    }

    @RequestMapping("/create")
    public ResponseEntity<?> createProject(@Valid ProjectResource projectResource) {
        Project project = ProjectResourceMapper.mapToProject(projectResource);
        projectService.createProject(project);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{projectId}/delete")
    public void deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
    }

    @RequestMapping("/update}")
    public ResponseEntity<?> updateProject(ProjectResource projectResource) {
        Project project = ProjectResourceMapper.mapToProject(projectResource);
        projectService.updateProject(project);
        return ResponseEntity.ok().build();
    }
}
