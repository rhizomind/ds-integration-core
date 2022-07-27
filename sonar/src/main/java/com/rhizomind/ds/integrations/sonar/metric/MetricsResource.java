package com.rhizomind.ds.integrations.sonar.metric;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api/metrics")
@Produces(MediaType.APPLICATION_JSON)
public interface MetricsResource {

    @GET
    @Path("search")
    MetricSearchResultRepresentation search(
            @QueryParam("p") @DefaultValue("1") Integer pageNumber,
            @QueryParam("ps") @DefaultValue("100") Integer pageSize
    );

    @GET
    @Path("types")
    MetricTypesRepresentation types();

}
