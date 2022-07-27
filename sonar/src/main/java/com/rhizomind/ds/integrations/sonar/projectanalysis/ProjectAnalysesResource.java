package com.rhizomind.ds.integrations.sonar.projectanalysis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/project_analyses")
@Produces(MediaType.APPLICATION_JSON)
public interface ProjectAnalysesResource {

    @GET
    @Path("search")
    ProjectAnalysesSearchResultRepresentation search();

}
