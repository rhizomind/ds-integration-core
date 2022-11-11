package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.cloud.projects.ProjectRepresentation;
import com.rhizomind.ds.integrations.bitbucket.cloud.workspace.WorkspaceRepresentation;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class CommitRepresentation {

    private String hash;

    private String message;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
