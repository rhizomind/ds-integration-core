package com.rhizomind.ds.integrations.gitlab;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

public interface UserResource {

    @GET
    @Path("projects")
    List<ProjectRepresentation> getAllProjects();

}
