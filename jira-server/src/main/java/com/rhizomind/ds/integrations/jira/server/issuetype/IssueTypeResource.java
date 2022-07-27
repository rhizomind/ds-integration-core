package com.rhizomind.ds.integrations.jira.server.issuetype;

import javax.ws.rs.GET;

public interface IssueTypeResource {

    @GET
    IssueTypeRepresentation toRepresentation();

}
