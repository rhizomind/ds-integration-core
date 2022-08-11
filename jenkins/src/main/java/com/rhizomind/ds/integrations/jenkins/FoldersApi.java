package com.rhizomind.ds.integrations.jenkins;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface FoldersApi {

    @POST
    @Path("createItem")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createFolder( MultivaluedMap<String, String> form);

    /**
     *
     * @param path eg: job/{foldername}/job/foldername
     * @param form
     * @return
     */
    @POST
    @Path("{path}/createItem")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createSubFolder(@PathParam("path") String path, MultivaluedMap<String, String> form);

}
