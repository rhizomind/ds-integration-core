package com.rhizomind.ds.integrations.jira.server.version;

import javax.ws.rs.GET;

public interface VersionResource {

    @GET
    VersionRepresentation toRepresentation();

}
