package com.rhizomind.ds.integrations.jira.server.version;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VersionForm {

    private String description;
    private String name;
    private boolean archived;
    private boolean released;
    private LocalDate releaseDate;
    private LocalDate startDate;
    private String project;
    private String projectId;

}
