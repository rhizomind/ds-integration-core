package com.rhizomind.ds.integrations.jira.server.status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("rest/api/2/status")
@Produces(MediaType.APPLICATION_JSON)
public interface StatusesResource {

    @Path("{id}")
    StatusResource findOne(@PathParam("id") String id);

    @GET
    List<StatusRepresentation> getAll();

}
