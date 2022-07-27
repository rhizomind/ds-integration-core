package com.rhizomind.ds.integrations.sonar.component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api/components")
@Produces(MediaType.APPLICATION_JSON)
public interface ComponentsResource {

    /**
     *
     * @param pageNumber 1-based page number
     * @param pageSize Page size. Must be greater than 0 and less or equal than 500
     * @param q
     * @param qualifiers Possible values are:
     * APP - Applications
     * VW - Portfolios
     * SVW - Portfolios
     * TRK - Projects
     * @return
     */
    @GET
    @Path("search_projects")
    ProjectSearchResultRepresentation searchProjects(
            @QueryParam("p") String pageNumber,
            @QueryParam("ps") String pageSize,
            @QueryParam("q") String q,
            @QueryParam("qualifiers") List<String> qualifiers
    );

}
