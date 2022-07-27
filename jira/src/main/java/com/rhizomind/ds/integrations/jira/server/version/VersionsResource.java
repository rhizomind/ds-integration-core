package com.rhizomind.ds.integrations.jira.server.version;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("version")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VersionsResource {

    @Path("{id}")
    VersionResource findOne(@PathParam("id") String id);

    @POST
    VersionRepresentation create(VersionForm versionForm);

}
