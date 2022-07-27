package com.rhizomind.ds.integrations.jira.server.issue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("rest/api/2/issue")
@Produces(MediaType.APPLICATION_JSON)
public interface IssuesResource {

    @Path("{issueIdOrKey}")
    IssueResource getIssue(@PathParam("issueIdOrKey") String idOrKey);

}
