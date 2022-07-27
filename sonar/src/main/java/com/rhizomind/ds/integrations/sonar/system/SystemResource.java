package com.rhizomind.ds.integrations.sonar.system;

import com.rhizomind.ds.integrations.sonar.projectanalysis.ProjectAnalysesSearchResultRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/system")
@Produces(MediaType.APPLICATION_JSON)
public interface SystemResource {

    /**
     * requires Administrator permissions
     * @return
     */
    @GET
    @Path("health")
    SystemHealthRepresentation health();

    /**
     * requires Administrator permissions
     * @return
     */
    @GET
    @Path("info")
    SystemInfoRepresentation info();

    @GET
    @Path("ping")
    String ping();

}
