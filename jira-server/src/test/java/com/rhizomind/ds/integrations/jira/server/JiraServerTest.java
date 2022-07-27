package com.rhizomind.ds.integrations.jira.server;

import com.rhizomind.ds.integrations.jira.server.project.*;
import com.rhizomind.ds.integrations.jira.server.projectcategory.ProjectCategoriesResource;
import com.rhizomind.ds.integrations.jira.server.projectcategory.ProjectCategoryRepresentation;
import com.rhizomind.ds.integrations.jira.server.serverinfo.ServerInfo;
import com.rhizomind.ds.integrations.jira.server.serverinfo.ServerInfoResource;
import com.rhizomind.ds.integrations.jira.server.status.StatusCategoriesResource;
import com.rhizomind.ds.integrations.jira.server.status.StatusCategoryRepresentation;
import com.rhizomind.ds.integrations.jira.server.status.StatusRepresentation;
import com.rhizomind.ds.integrations.jira.server.status.StatusesResource;
import com.rhizomind.ds.integrations.jira.server.version.VersionForm;
import com.rhizomind.ds.integrations.jira.server.version.VersionRepresentation;
import com.rhizomind.ds.integrations.jira.server.version.VersionsResource;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JiraServerTest {

    @Test
    void serverInfoResource() throws MalformedURLException {
        JiraServer jiraServer = new JiraServer(
                null,
                null,
                null,
                new RestEasyClientFactoryBuilder()
        );

        ProjectsResource projectsResource = jiraServer.projectsResource();
        ServerInfoResource serverInfoResource = jiraServer.serverInfoResource();
        ProjectCategoriesResource projectCategoriesResource = jiraServer.projectCategoriesResource();
        VersionsResource versionsResource = jiraServer.versionsResource();
        StatusesResource statusesResource = jiraServer.statusesResource();
        StatusCategoriesResource statusCategoriesResource = jiraServer.statusesCategoriesResource();

        ServerInfo serverInfo = serverInfoResource.toRepresentation();
        List<ProjectCategoryRepresentation> categories = projectCategoriesResource.findAll();
        List<ProjectRepresentation> projects = projectsResource.findAll();

        List<StatusCategoryRepresentation> statusCategoryRepresentations = statusCategoriesResource.getAll();
        List<StatusRepresentation> statusRepresentations = statusesResource.getAll();

        projects.forEach(
                project -> {
                    ProjectResource projectResource = projectsResource.findOne(project.getId());

                    ProjectRepresentation projectRepresentation = projectResource.toRepresentation();
                    ProjectAvatarsRepresentation projectAvatars = projectResource.getProjectAvatars();
                    List<ProjectComponentRepresentation> projectComponents = projectResource.getProjectComponents();
                    List<VersionRepresentation> projectVersions = projectResource.getProjectVersions();

                    VersionRepresentation versionRepresentation = versionsResource.create(VersionForm.builder()
                            .name("test")
                            .project(project.getKey())
                            .projectId(project.getId())
                            .description("testing api integration")
                            .releaseDate(LocalDate.of(2022, 7, 25))
                                    .released(true)
                                    .startDate(LocalDate.of(2022, 7, 20))
                            .build());

                    System.out.println(projectRepresentation);
                }
        );

    }
}