package com.rhizomind.ds.integrations.gitlab;

import javax.ws.rs.*;
import java.util.List;

@Path("api/v4/groups")
@Produces("application/json")
@Consumes("application/json")
public interface GroupsResource {

    @GET
    List<GroupRepresentation> getALl(@QueryParam("page") Integer page);


    @Path("{gruopId}")
    GroupResource getGroup(@PathParam("gruopId") int groupId);

}
