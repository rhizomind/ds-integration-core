package com.rhizomind.ds.integrations.sonar.projectanalysis;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ProjectAnalysisRepresentation {

    private String key;
    private String revision;
    private String projectVersion;
    private ZonedDateTime date;

}
