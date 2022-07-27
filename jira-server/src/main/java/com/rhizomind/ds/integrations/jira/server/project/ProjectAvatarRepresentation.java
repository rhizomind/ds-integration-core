package com.rhizomind.ds.integrations.jira.server.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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

}
