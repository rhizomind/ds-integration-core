package com.rhizomind.ds.integrations.sonar.measures;

import javax.management.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api/measures")
@Produces(MediaType.APPLICATION_JSON)
public interface MeasuresResource {

    /**
     *
     * @param fields available values: metrics,period,periods
     * @return
     */
    @GET
    @Path("component")
    ComponentMeasuresRepresentation component(
            @QueryParam("additionalFields") List<String> fields,
            @QueryParam("component") ComponentKey componentKey,
            @QueryParam("metricKeys") List<String> metricKeys,
            @QueryParam("pullRequest") String pullRequestId
    );

}
