package com.rhizomind.ds.integrations.jenkins.credentials;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CredentialsApi {

    /**
     *
     * @param path eg: 'job/{foldername}/job/foldername'
     * @param form json={"credentials": {"username": "test", "usernameSecret": true, "password": "test", "$redact": "password", "id": "test", "description": "test", "stapler-class": "com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl"}}
     * @return
     */
    @POST
    @Path("{path}/credentials/store/folder/domain/_/createCredentials")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response modifyCredentials(@PathParam("path") String path, MultivaluedMap<String, String> form);

}
