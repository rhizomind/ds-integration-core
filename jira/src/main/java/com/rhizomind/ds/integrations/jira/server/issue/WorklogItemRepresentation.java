package com.rhizomind.ds.integrations.jira.server.issue;

import com.rhizomind.ds.integrations.jira.server.user.UserRepresentation;
import lombok.Data;

import java.net.URL;
import java.time.ZonedDateTime;

@Data
public class WorklogItemRepresentation {

    private UserRepresentation author;
    private String comment;
    private String id;
    private String issueId;
    private URL self;
    private ZonedDateTime started;
    private String timeSpent;
    private int timeSpentSeconds;
    private UserRepresentation updateAuthor;
    private ZonedDateTime updated;

}
