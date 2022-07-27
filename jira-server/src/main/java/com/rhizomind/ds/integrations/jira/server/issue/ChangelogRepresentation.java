package com.rhizomind.ds.integrations.jira.server.issue;

import lombok.Data;

import java.util.List;

@Data
public class ChangelogRepresentation {

    private List<ChangelogEntryRepresentation> histories;

    private int maxResults;
    private int startAt;
    private int total;

}
