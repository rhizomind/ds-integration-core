package com.rhizomind.ds.integrations.jira.server.status;

import javax.ws.rs.GET;

public interface StatusCategoryResource {

    @GET
    StatusCategoryRepresentation toRepresentation();


}
