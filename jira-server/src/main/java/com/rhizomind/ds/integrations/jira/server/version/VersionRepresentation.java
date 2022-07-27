package com.rhizomind.ds.integrations.jira.server.version;

import lombok.Data;
import lombok.ToString;

import java.net.URL;
import java.time.LocalDate;

@Data
@ToString
public class VersionRepresentation {

    private URL self;
    private String id;
    private String description;
    private String name;

    private LocalDate releaseDate;
    private String userReleaseDate;

    private LocalDate startDate;
    private String userStartDate;

    private boolean archived;
    private boolean released;
    private boolean overdue;
    private Integer projectId;

}
