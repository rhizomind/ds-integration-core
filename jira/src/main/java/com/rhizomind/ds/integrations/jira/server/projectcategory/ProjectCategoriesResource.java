package com.rhizomind.ds.integrations.jira.server.projectcategory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("projectCategory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProjectCategoriesResource {

    @GET
    List<ProjectCategoryRepresentation> findAll();

    @Path("{id}")
    ProjectCategoryResource findOne(@PathParam("id") String id);

}
