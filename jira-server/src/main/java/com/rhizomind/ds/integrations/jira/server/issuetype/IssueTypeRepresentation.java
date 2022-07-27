package com.rhizomind.ds.integrations.jira.server.issuetype;

import lombok.Data;

@Data
public class IssueTypeRepresentation {

    private String id;
    private String name;
    private String description;
    private String self;
    private boolean subtask;

}
