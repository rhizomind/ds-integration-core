package com.rhizomind.ds.integrations.jira.server.projectcategory;

import javax.ws.rs.GET;

public interface ProjectCategoryResource {

    @GET
    ProjectCategoryRepresentation toRepresentation();

}
