package com.rhizomind.ds.integrations.jira.server.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("statuscategory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface StatusCategoriesResource {

    @Path("{id}")
    StatusCategoryResource findOne(@PathParam("id") String id);

    @GET
    List<StatusCategoryRepresentation> getAll();

}
