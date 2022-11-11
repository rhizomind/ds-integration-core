package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import javax.ws.rs.GET;

public interface WorkspaceResource {

    @GET
    WorkspaceMembershipRepresentation toRepresentation();

}
