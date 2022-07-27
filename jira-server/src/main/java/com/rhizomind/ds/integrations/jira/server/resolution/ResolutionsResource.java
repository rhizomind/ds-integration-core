package com.rhizomind.ds.integrations.jira.server.resolution;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("rest/api/2/resolution")
@Produces(MediaType.APPLICATION_JSON)
public interface ResolutionsResource {

    @Path("{id}")
    ResolutionResource findOne(@PathParam("id") String id);

    @GET
    List<ResolutionRepresentation> getAll();

}
