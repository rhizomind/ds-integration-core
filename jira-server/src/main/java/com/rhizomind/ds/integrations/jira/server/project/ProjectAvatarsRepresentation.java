package com.rhizomind.ds.integrations.jira.server.project;

import lombok.Data;

import java.util.List;

@Data
public class ProjectAvatarsRepresentation {

    private List<ProjectAvatarRepresentation> system;
    private List<ProjectAvatarRepresentation> custom;

}
