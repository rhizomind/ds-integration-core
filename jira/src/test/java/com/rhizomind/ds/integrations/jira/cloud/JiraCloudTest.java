package com.rhizomind.ds.integrations.jira.cloud;

import com.rhizomind.ds.integrations.jira.server.issue.FixVersionsForm;
import com.rhizomind.ds.integrations.jira.server.issue.IssueResource;
import com.rhizomind.ds.integrations.jira.server.issue.IssueUpdateForm;
import com.rhizomind.ds.integrations.jira.server.issue.IssuesResource;
import com.rhizomind.ds.integrations.jira.server.issuetype.IssueTypeRepresentation;
import com.rhizomind.ds.integrations.jira.server.issuetype.IssueTypesResource;
import com.rhizomind.ds.integrations.jira.server.project.ProjectRepresentation;
import com.rhizomind.ds.integrations.jira.server.project.ProjectResource;
import com.rhizomind.ds.integrations.jira.server.project.ProjectsResource;
import com.rhizomind.ds.integrations.jira.server.serverinfo.ServerInfo;
import com.rhizomind.ds.integrations.jira.server.serverinfo.ServerInfoResource;
import com.rhizomind.ds.integrations.jira.server.version.VersionForm;
import com.rhizomind.ds.integrations.jira.server.version.VersionRepresentation;
import com.rhizomind.ds.integrations.jira.server.version.VersionsResource;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static com.rhizomind.ds.integrations.jira.server.project.ProjectsResource.Expand.all;
import static java.util.Arrays.asList;

class JiraCloudTest {

    @Test
    void serverInfoResource() throws MalformedURLException {
        JiraCloud jiraServer = new JiraCloud(
                null,
                null,
                null,
                new RestEasyClientFactoryBuilder()
        );

        ServerInfoResource serverInfoResource = jiraServer.serverInfoResource();
        ProjectsResource projectsResource = jiraServer.projectsResource();
        IssueTypesResource issueTypesResource = jiraServer.issueTypesResource();
        IssuesResource issuesResource = jiraServer.issuesResource();
        VersionsResource versionsResource = jiraServer.versionsResource();

        ServerInfo serverInfo = serverInfoResource.toRepresentation();
        List<ProjectRepresentation> allProjects = projectsResource.findAll(all());
        List<IssueTypeRepresentation> issueTypes = issueTypesResource.findAll();



        try {
            ProjectResource htbResource = projectsResource.findOne("HTB");
            IssueResource htb691 = issuesResource.getIssue("HTB-691");
            VersionRepresentation versionRepresentation = htbResource.getProjectVersions().stream().filter(pv -> pv.getName().equalsIgnoreCase("test-version-name"))
                    .findFirst()
                    .orElseGet(() -> {
                        ProjectRepresentation htb = htbResource.toRepresentation();
                        return versionsResource.create(VersionForm.builder()
                                .project(htb.getKey())
                                .projectId(htb.getId())
                                .name("test-version-name")
                                .description("test-version-description")
                                .startDate(LocalDate.now())
                                .build()
                        );
                    });

            HashMap<String, Object> fields = new HashMap<>();
            fields.put("fixVersions", asList( new FixVersionsForm(versionRepresentation.getId(), versionRepresentation.getName())));
            htb691.update(
                    IssueUpdateForm.builder()
                            .fields(fields)
                            .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}