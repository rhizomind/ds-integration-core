package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import com.rhizomind.ds.integrations.bitbucket.cloud.PagedResult;
import com.rhizomind.ds.integrations.bitbucket.cloud.projects.ProjectRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface WorkspaceResource {

    @GET
    WorkspaceMembershipRepresentation toRepresentation();

    @GET
    @Path("projects")
    PagedResult<ProjectRepresentation> getProjects();

}
