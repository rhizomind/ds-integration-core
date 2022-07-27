package com.rhizomind.ds.integrations.jira.server.project;

import com.rhizomind.ds.integrations.jira.server.projectcategory.ProjectCategoryRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class ProjectRepresentation {

    private String id;
    private String key;
    private String name;
    private String projectTypeKey;
    private Map<String, String> avatarUrls;
    private ProjectCategoryRepresentation projectCategory;

}
