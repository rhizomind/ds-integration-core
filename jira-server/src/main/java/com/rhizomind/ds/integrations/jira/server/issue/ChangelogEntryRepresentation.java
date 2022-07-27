package com.rhizomind.ds.integrations.jira.server.issue;

import com.rhizomind.ds.integrations.jira.server.user.UserRepresentation;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class ChangelogEntryRepresentation {

    private UserRepresentation author;
    private ZonedDateTime created;
    private int id;
    private List<ChangeLogEntryItemRepresentation> items;

}
