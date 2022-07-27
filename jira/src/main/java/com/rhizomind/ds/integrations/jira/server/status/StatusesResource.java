package com.rhizomind.ds.integrations.jira.server.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface StatusesResource {

    @Path("{id}")
    StatusResource findOne(@PathParam("id") String id);

    @GET
    List<StatusRepresentation> getAll();

}
