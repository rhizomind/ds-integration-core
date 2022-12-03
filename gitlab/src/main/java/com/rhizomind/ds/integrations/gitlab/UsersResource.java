package com.rhizomind.ds.integrations.gitlab;

import javax.ws.rs.*;

@Path("api/v4")
@Produces("application/json")
@Consumes("application/json")
public interface UsersResource {

    @GET
    @Path("user")
    UserRepresentation currentUser();

    @Path("users/{userId}")
    UserResource getOne(@PathParam("userId") String userId);

}
