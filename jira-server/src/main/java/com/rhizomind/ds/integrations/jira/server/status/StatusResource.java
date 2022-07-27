package com.rhizomind.ds.integrations.jira.server.status;

import com.rhizomind.ds.integrations.jira.server.project.ProjectRepresentation;

import javax.ws.rs.GET;

public interface StatusResource {

    @GET
    StatusRepresentation toRepresentation();

}
