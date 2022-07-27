package com.rhizomind.ds.integrations.jira.server.serverinfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("rest/api/2/serverInfo")
public interface ServerInfoResource {

    @GET
    ServerInfo toRepresentation();

}
