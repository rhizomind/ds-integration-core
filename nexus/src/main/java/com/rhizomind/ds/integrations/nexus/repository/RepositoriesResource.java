package com.rhizomind.ds.integrations.nexus.repository;

import com.rhizomind.ds.integrations.nexus.repository.docker.DockerHostedRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.maven.MavenGroupRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.maven.MavenHostedRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.maven.MavenProxyRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.raw.RawHostedRepositoryForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/repositories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RepositoriesResource {

    @GET
    List<RepositoryRepresentation> findAll();

    @POST
    @Path("docker/hosted")
    void createDockerHostedRepository(DockerHostedRepositoryForm form);
    @GET
    @Path("docker/hosted/{name}")
    DockerHostedRepositoryForm getDockerHostedRepository(@PathParam("name") String name);


    @POST
    @Path("maven/hosted")
    void createMavenHostedRepository(MavenHostedRepositoryForm form);
    @GET
    @Path("maven/hosted/{name}")
    MavenHostedRepositoryForm getMavenHostedRepository(@PathParam("name") String name);

    @POST
    @Path("maven/group")
    void createMavenGroupRepository(MavenGroupRepositoryForm form);
    @GET
    @Path("maven/group/{name}")
    MavenGroupRepositoryForm getMavenGroupRepository(@PathParam("name") String name);

    @POST
    @Path("maven/proxy")
    void createMavenProxyRepository(MavenProxyRepositoryForm form);
    @GET
    @Path("maven/proxy/{name}")
    MavenProxyRepositoryForm getMavenProxyRepository(@PathParam("name") String name);


    @POST
    @Path("raw/hosted")
    void createRawHostedRepository(RawHostedRepositoryForm form);

    @GET
    @Path("raw/hosted/{name}")
    RawHostedRepositoryForm getRawHostedRepository(@PathParam("name") String name);
}
