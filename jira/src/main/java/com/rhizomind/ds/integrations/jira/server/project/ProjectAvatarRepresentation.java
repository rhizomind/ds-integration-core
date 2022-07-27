package com.rhizomind.ds.integrations.jira.server.project;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProjectAvatarRepresentation {

    private String id;
    private String owner;
    @JsonProperty("isSystemAvatar")
    private boolean systemAvatar;
    @JsonProperty("isSelected")
    private boolean selected2;
    @JsonProperty("isDeletable")
    private boolean deletable;
    private Map<String, String> urls;
    private boolean selected;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();



}
