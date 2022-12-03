package com.rhizomind.ds.integrations.gitlab;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

public interface GroupResource {

    @GET
    GroupRepresentation toRepresentation();

    @GET
    @Path("projects")
    List<ProjectRepresentation> getAll();

}
