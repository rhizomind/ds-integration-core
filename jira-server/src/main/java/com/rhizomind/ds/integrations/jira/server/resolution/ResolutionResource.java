package com.rhizomind.ds.integrations.jira.server.resolution;

import javax.ws.rs.GET;

public interface ResolutionResource {

    @GET
    ResolutionRepresentation toRepresentation();

}
