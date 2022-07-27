package com.rhizomind.ds.integrations.jira.server.issue;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("issue")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IssuesResource {

    @Path("{issueIdOrKey}")
    IssueResource getIssue(@PathParam("issueIdOrKey") String idOrKey);

}
