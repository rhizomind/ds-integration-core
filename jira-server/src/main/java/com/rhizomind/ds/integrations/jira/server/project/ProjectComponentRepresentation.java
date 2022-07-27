package com.rhizomind.ds.integrations.jira.server.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.jira.server.user.UserRepresentation;
import lombok.Data;

import java.net.URL;

@Data
public class ProjectComponentRepresentation {

    private String id;
    private String name;
    private String description;
    private URL self;

    private String assigneeType;
    private UserRepresentation assignee;
    private String realAssigneeType;
    private UserRepresentation realAssignee;

    private String project;
    private int projectId;
    @JsonProperty("isAssigneeTypeValid")
    private boolean assigneeTypeValid;

}
