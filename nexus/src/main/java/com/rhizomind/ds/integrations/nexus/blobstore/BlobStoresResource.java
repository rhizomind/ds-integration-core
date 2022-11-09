package com.rhizomind.ds.integrations.nexus.blobstore;

import com.rhizomind.ds.integrations.nexus.repository.RepositoryRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/blobstores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BlobStoresResource {

    @GET
    List<BlobStoreRepresentation> findAll();

    @POST
    @Path("file")
    void createFileBlobStore(FileBlobStoreForm form);

    @GET
    @Path("file/{name}")
    BlobStoreRepresentation getFileBlobStore(@PathParam("name") String name);
}
