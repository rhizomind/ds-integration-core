package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;

import javax.ws.rs.*;

@Path("/api/2.0/user/permissions/workspaces")
@Produces("application/json")
@Consumes("application/json")
public interface WorkspacesResource {

    @GET
    PagedResult<WorkspaceMembershipRepresentation> getAll();

    @Path("{workspace}")
    WorkspaceResource getOne(@PathParam("workspace") String workspace);

}
