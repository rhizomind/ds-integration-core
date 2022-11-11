package com.rhizomind.ds.integrations.jenkins.jobs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface JobsApi {

    @GET
    @Path("{path}/api/json")
    ItemInfoDto getItemInfo(@PathParam("path") String path);

    @POST
    @Path("{path}/createItem")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createItem(@PathParam("path") String path, MultivaluedMap<String, String> form);

    @POST
    @Path("{path}/job/{jobname}/configSubmit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response submitItemConfig(@PathParam("path") String path, @PathParam("jobname") String jobname, MultivaluedMap<String, String> form);

}
