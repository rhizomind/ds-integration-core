package com.rhizomind.ds.integrations.jira.server.issue;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
public interface IssueResource {

    @GET
    Optional<IssueRepresentation> toRepresentation(@QueryParam("expand") String expand);

}
