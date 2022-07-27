package com.rhizomind.ds.integrations.jira.server.project;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("rest/api/2/project")
@Produces(MediaType.APPLICATION_JSON)
public interface ProjectsResource {

    @GET
    List<ProjectRepresentation> findAll();

    @Path("{id}")
    ProjectResource findOne(@PathParam("id") String id);

}
