package com.rhizomind.ds.integrations.jira.server.project;

import com.rhizomind.ds.integrations.jira.server.version.VersionRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProjectResource {

    @GET
    ProjectRepresentation toRepresentation();

    @GET
    @Path("avatars")
    ProjectAvatarsRepresentation getProjectAvatars();

    @GET
    @Path("versions")
    List<VersionRepresentation> getProjectVersions();

    @GET
    @Path("components")
    List<ProjectComponentRepresentation> getProjectComponents();

}
