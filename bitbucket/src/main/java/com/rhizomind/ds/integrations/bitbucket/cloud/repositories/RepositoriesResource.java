package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;

import javax.ws.rs.*;

@Path("/api/2.0/repositories")
@Produces("application/json")
@Consumes("application/json")
public interface RepositoriesResource {

    @GET
    PagedResult<RepositoryRepresentation> getAll();

    @Path("{workspace}")
    WorkspaceRepositoriesResource getWorkspaceRepositories(@PathParam("workspace") String workspace);

}
