package com.rhizomind.ds.integrations.jira.server.project;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ProjectAvatarsRepresentation {

    private List<ProjectAvatarRepresentation> system;
    private List<ProjectAvatarRepresentation> custom;


    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();

}
