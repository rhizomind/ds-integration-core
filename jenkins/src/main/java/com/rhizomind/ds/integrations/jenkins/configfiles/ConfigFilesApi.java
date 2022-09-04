package com.rhizomind.ds.integrations.jenkins.configfiles;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ConfigFilesApi {

    @POST
    @Path("configfiles/addConfig")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createConfigFile(MultivaluedMap<String, String> form);

    /**
     *
     * @param path eg: 'job/{foldername}/job/foldername'
     * @param form provider=org.jenkinsci.plugins.configfiles.custom.CustomConfig, configId={anything}
     * @return
     */
    @POST
    @Path("{path}/configfiles")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createConfigFile(@PathParam("path") String path, @QueryParam("name") String name, MultivaluedMap<String, String> form);


    /**
     *
     * @param path eg: 'job/{foldername}/job/foldername'
     * @param form json={"config":{"stapler-class":"org.jenkinsci.plugins.configfiles.custom.CustomConfig","id":"123","providerId":"org.jenkinsci.plugins.configfiles.custom.CustomConfig","name":"name-123","comment":"comment-123","content":"content-123"}}
     * @return
     */
    @POST
    @Path("{path}/configfiles/saveConfig")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response modifyConfigFile(@PathParam("path") String path, MultivaluedMap<String, String> form);

}
