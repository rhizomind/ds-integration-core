package com.rhizomind.ds.integrations.jira.server.project;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.rhizomind.ds.integrations.jira.server.issuetype.IssueTypeRepresentation;
import com.rhizomind.ds.integrations.jira.server.projectcategory.ProjectCategoryRepresentation;
import com.rhizomind.ds.integrations.jira.server.user.UserRepresentation;
import com.rhizomind.ds.integrations.jira.server.version.VersionRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class ProjectRepresentation {

    private String expand;
    private String self;
    private String id;
    private String key;
    private List<String> projectKeys;
    private String description;
    private UserRepresentation lead;
    private List<ProjectComponentRepresentation> components;
    private List<IssueTypeRepresentation> issueTypes;
    private String url;
    private String email;
    private String assigneeType;
    private List<VersionRepresentation> versions;
    private String name;
    private Map<String, String> avatarUrls;
    private ProjectCategoryRepresentation projectCategory;
    private String projectTypeKey;
    private Boolean simplified;
    private String style;


    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();


}
