package com.rhizomind.ds.integrations.jira.server.version;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.ToString;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    private Boolean archived;
    private Boolean released;
    private Boolean overdue;
    private Integer projectId;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();

}
