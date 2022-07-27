package com.rhizomind.ds.integrations.jira.server.resolution;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("resolution")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResolutionsResource {

    @Path("{id}")
    ResolutionResource findOne(@PathParam("id") String id);

    @GET
    List<ResolutionRepresentation> getAll();

}
