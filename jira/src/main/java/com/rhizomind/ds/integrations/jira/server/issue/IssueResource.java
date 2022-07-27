package com.rhizomind.ds.integrations.jira.server.issue;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IssueResource {

    @GET
    Optional<IssueRepresentation> toRepresentation(@QueryParam("expand") String expand);

    @PUT
    void update(IssueUpdateForm issueUpdateForm);

}
