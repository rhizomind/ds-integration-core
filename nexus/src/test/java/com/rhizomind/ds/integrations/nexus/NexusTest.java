package com.rhizomind.ds.integrations.nexus;

import com.rhizomind.ds.integrations.nexus.blobstore.BlobStoreRepresentation;
import com.rhizomind.ds.integrations.nexus.repository.RepositoryRepresentation;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

class NexusTest {

    @Test
    void name() throws MalformedURLException {
        Nexus nexus = new Nexus(
                new URL("https://nexus.accuratus.solidify.pl/"),
                "tomasz.krzyzak",
                "...",
                new RestEasyClientFactoryBuilder()
        );

        List<RepositoryRepresentation> all = nexus.repositoriesResource().findAll();

        List<BlobStoreRepresentation> all1 = nexus.blobStoresResource().findAll();
    }
}