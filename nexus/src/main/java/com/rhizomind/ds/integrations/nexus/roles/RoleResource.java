package com.rhizomind.ds.integrations.nexus.roles;

import javax.ws.rs.GET;

public interface RoleResource {

    @GET
    RoleRepresentation toRoleRepresentation();

}
