package com.rhizomind.ds.integrations.jenkins.system;

import org.jboss.resteasy.annotations.ResponseObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public interface SystemApi {

    @HEAD
    Response systemInfo();

    @Path("quietDown")
    @Consumes({"text/html"})
    @POST
    Response quietDown();

    @Path("cancelQuietDown")
    @Consumes({"text/html"})
    @POST
    Response cancelQuietDown();
}
