package com.rhizomind.ds.integrations.jira.server.issuetype;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
public class IssueTypeRepresentation {

    private String id;
    private String name;
    private String description;
    private String self;
    private Boolean subtask;
    private String avatarId;
    private URL iconUrl;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();


}
