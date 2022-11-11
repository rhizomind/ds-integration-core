package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;

import javax.ws.rs.*;

@Produces("application/json")
@Consumes("application/json")
public interface RepositoryResource {

    @GET
    RepositoryRepresentation toRepresentation();

    @GET
    @Path("src/{hash}/")
    PagedResult<TreeEntryRepresentation> getSrc(@PathParam("hash") String hash, @QueryParam("page") Integer page, @QueryParam("pagelen") Integer pagelen);

    @GET
    @Path("commits")
    PagedResult<CommitRepresentation> getCommits(@QueryParam("pagelen") Integer pagelen, @QueryParam("include") String includeBranch);

}
