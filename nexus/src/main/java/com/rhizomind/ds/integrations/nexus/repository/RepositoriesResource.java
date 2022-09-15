package com.rhizomind.ds.integrations.nexus.repository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/repositories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RepositoriesResource {

    @GET
    List<RepositoryRepresentation> findAll();

}
