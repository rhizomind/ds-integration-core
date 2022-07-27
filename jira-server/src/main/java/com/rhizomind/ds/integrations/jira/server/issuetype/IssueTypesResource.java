package com.rhizomind.ds.integrations.jira.server.issuetype;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("rest/api/2/issuetype")
@Produces(MediaType.APPLICATION_JSON)
public interface IssueTypesResource {

    @GET
    List<IssueTypeRepresentation> findAll();

    @Path("{id}")
    IssueTypeResource findOne(@PathParam("id")String issueTypeId);

}
