package com.rhizomind.ds.integrations.jira.server.issue;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
public class IssueRepresentation {

    private String key;
    private String id;

    private URL self;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

    private IssueFieldsRepresentation fields;

    private ChangelogRepresentation changelog;

}
