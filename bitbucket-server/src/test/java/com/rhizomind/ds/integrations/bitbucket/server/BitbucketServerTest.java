package com.rhizomind.ds.integrations.bitbucket.server;

import com.rhizomind.ds.integrations.bitbucket.server.projects.*;
import com.rhizomind.ds.integrations.bitbucket.server.serverinfo.ApplicationPropertiesRepresentation;
import com.rhizomind.ds.integrations.bitbucket.server.serverinfo.ApplicationPropertiesResource;
import com.rhizomind.ds.integrations.bitbucket.server.users.UsersResource;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

class BitbucketServerTest {

    @Test
    void name() {
        BitbucketServer bitbucketServer = new BitbucketServer(
                "https://bitbucket.solidify.pl/",
                "NTkxMzY1NDQwNDgxOma8fSZbo6/JsuWn/lKR3jeJD3bv",
                new RestEasyClientFactoryBuilder()
        );
        ApplicationPropertiesResource applicationPropertiesResource = bitbucketServer.systemResource();

        ProjectsResource projectsResource = bitbucketServer.projectsResource();
        ApplicationPropertiesRepresentation applicationPropertiesRepresentation = applicationPropertiesResource.applicationProperties();
        PagedResult<ProjectRepresentation> all = projectsResource.getAll();

        all.getValues().forEach(p -> {
            System.out.println(p.getKey());
            ReposResource projectReposResource = projectsResource.getProjectReposResource(p.getKey());
            projectReposResource.getAll().getValues().forEach(pr -> {
                RepoTagsPage repoTagsPage = projectReposResource.getOne(pr.getSlug()).getRepoTagsPage();

                System.out.println("\t"+pr.getSlug()+" - "+repoTagsPage.getValues());
            });

        });

        UsersResource usersResource = bitbucketServer.usersResource();
        usersResource.getAll().getValues().forEach( u -> {
            System.out.println(u);
        });
    }
}