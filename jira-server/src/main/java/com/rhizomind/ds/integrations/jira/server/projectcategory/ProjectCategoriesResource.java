package com.rhizomind.ds.integrations.jira.server.projectcategory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("rest/api/2/projectCategory")
@Produces(MediaType.APPLICATION_JSON)
public interface ProjectCategoriesResource {

    @GET
    List<ProjectCategoryRepresentation> findAll();

    @Path("{id}")
    ProjectCategoryResource findOne(@PathParam("id") String id);

}
