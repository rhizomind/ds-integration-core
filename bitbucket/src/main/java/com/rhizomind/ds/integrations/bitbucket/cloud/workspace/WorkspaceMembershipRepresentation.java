package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.cloud.UserRepresentation;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class WorkspaceMembershipRepresentation {

    private String type;
    private String permission;

    @JsonProperty("last_accessed")
    private ZonedDateTime lastAccessed;
    @JsonProperty("added_on")
    private ZonedDateTime addedOn;

    private UserRepresentation user;
    private WorkspaceRepresentation workspace;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
