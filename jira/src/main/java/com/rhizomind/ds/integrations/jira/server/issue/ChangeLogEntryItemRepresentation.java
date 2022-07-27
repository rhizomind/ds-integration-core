package com.rhizomind.ds.integrations.jira.server.issue;

import lombok.Data;

@Data
public class ChangeLogEntryItemRepresentation {

    private String field;
    private String fieldtype;
    private String from;
    private String fromString;
    private String to;
    private String toString;

}
