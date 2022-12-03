package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;

import javax.ws.rs.*;

@Path("2.0")
@Produces("application/json")
@Consumes("application/json")
public interface WorkspacesResource {

    @GET
    @Path("user/permissions/workspaces")
    PagedResult<WorkspaceMembershipRepresentation> getAll();

    @Path("workspaces/{workspace}")
    WorkspaceResource getOne(@PathParam("workspace") String workspace);

}
