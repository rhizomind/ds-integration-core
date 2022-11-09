package com.rhizomind.ds.integrations.nexus.roles;

import com.rhizomind.ds.integrations.nexus.repository.RepositoryRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/security/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RolesResource {

    @GET
    List<RoleRepresentation> findAll();

    @GET
    @Path("{id}")
    RoleResource getOne(@PathParam("id") String id);

    @POST
    RoleRepresentation create(RoleForm roleForm);
    @PUT
    @Path("{id}")
    RoleRepresentation update(@PathParam("id") String roleId, RoleForm form);
}
