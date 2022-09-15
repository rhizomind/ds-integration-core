package com.rhizomind.ds.integrations.nexus.blobstore;

import com.rhizomind.ds.integrations.nexus.repository.RepositoryRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/blobstores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BlobStoresResource {

    @GET
    List<BlobStoreRepresentation> findAll();

}
