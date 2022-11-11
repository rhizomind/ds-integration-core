package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;

import javax.ws.rs.*;

@Produces("application/json")
@Consumes("application/json")
public interface WorkspaceRepositoriesResource {

    @GET
    PagedResult<RepositoryRepresentation> getAll(@QueryParam("page") Integer page, @QueryParam("pagelen") Integer pagelen);

    @Path("{repoSlug}")
    RepositoryResource getRepository(@PathParam("repoSlug") String repoSlug);

}
