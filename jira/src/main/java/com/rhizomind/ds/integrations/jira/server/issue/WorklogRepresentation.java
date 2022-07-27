package com.rhizomind.ds.integrations.jira.server.issue;

import lombok.Data;

import java.util.List;

@Data
public class WorklogRepresentation {

    private int maxResults;
    private int startAt;
    private int total;
    private List<WorklogItemRepresentation> worklogs;

}
