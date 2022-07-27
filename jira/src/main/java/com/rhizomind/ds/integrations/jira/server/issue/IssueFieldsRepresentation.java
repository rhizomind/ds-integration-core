package com.rhizomind.ds.integrations.jira.server.issue;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.jira.server.user.UserRepresentation;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class IssueFieldsRepresentation {

    private String summary;
    private ZonedDateTime created;
    @JsonProperty("resolutiondate")
    private ZonedDateTime resolutionDate;

    private UserRepresentation assignee;

    private UserRepresentation creator;

    private UserRepresentation reporter;

    private WorklogRepresentation worklog;


    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
