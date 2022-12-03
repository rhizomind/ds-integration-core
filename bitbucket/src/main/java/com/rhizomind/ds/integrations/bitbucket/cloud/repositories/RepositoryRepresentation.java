package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.cloud.projects.ProjectRepresentation;
import com.rhizomind.ds.integrations.bitbucket.cloud.workspace.WorkspaceRepresentation;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class RepositoryRepresentation {

    private String uuid;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("is_private")
    private boolean _private;

    private String scm;

    private String name;

    private String slug;

    private String description;

    private String type;

    private WorkspaceRepresentation workspace;

    private ProjectRepresentation project;

    @JsonProperty("fork_policy")
    private String forkPolicy;

    @JsonProperty("created_on")
    private ZonedDateTime created;

    @JsonProperty("updated_on")
    private ZonedDateTime updated;

    private int size;

    private String language;

    @JsonProperty("has_issues")
    private boolean hasIssues;

    @JsonProperty("has_wiki")
    private boolean hasWiki;

    @JsonProperty("mainbranch")
    private MainBranchRepresentation mainBranch;

    private RepositoryLinksRepresentation links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
