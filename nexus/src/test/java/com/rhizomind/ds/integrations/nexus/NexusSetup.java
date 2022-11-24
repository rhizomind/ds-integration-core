package com.rhizomind.ds.integrations.nexus;

import com.rhizomind.ds.integrations.nexus.blobstore.FileBlobStoreForm;
import com.rhizomind.ds.integrations.nexus.repository.docker.DockerHostedRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.docker.DockerHostedRepositoryStorageForm;
import com.rhizomind.ds.integrations.nexus.repository.docker.RepositoryDockerForm;
import com.rhizomind.ds.integrations.nexus.repository.maven.*;
import com.rhizomind.ds.integrations.nexus.repository.raw.RawHostedRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.AbstractRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryGroupForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryStorageForm;
import com.rhizomind.ds.integrations.nexus.roles.RoleForm;
import com.rhizomind.ds.integrations.nexus.roles.RoleRepresentation;
import com.rhizomind.ds.integrations.nexus.roles.RolesResource;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

class NexusTest {

    @Test
    void name() throws MalformedURLException {
        Nexus nexus = new Nexus(
                new URL("https://nexus.accu.account.solidify.pl/"),
                "tomasz.krzyzak",
                "xxx",
                new RestEasyClientFactoryBuilder()
        );

        String blobStoreName = ensureBlobStoreExists(nexus, "spreadium");
        ensureRepositoryExists(
                nexus,
                "maven2",
                MavenHostedRepositoryForm.builder()
                        .name("maven-releases")
                        .storage(MavenHostedRepositoryStorageForm.builder()
                                .blobStoreName(blobStoreName)
                                .build())
                        .maven(RepositoryMavenForm.builder().versionPolicy("RELEASE").build())
                        .build(),
                nexus.repositoriesResource()::getMavenHostedRepository,
                nexus.repositoriesResource()::createMavenHostedRepository
        );
        try {
            MavenHostedRepositoryForm snapshot = MavenHostedRepositoryForm.builder()
                    .name("maven-snapshots")
                    .storage(MavenHostedRepositoryStorageForm.builder()
                            .blobStoreName(blobStoreName)
                            .build())
                    .maven(RepositoryMavenForm.builder().versionPolicy("SNAPSHOT").build())
                    .build();
            ensureRepositoryExists(
                    nexus,
                    "maven2",
                    snapshot,
                    nexus.repositoriesResource()::getMavenHostedRepository,
                    nexus.repositoriesResource()::createMavenHostedRepository
            );
        } catch (WebApplicationException e) {
            System.out.println(e.getResponse().readEntity(String.class));
        }

        ensureRepositoryExists(
                nexus,
                "maven2",
                MavenProxyRepositoryForm.builder()
                        .name("maven-central")
                        .storage(RepositoryStorageForm.builder()
                                .blobStoreName(blobStoreName)
                                .build())
                        .build(),
                nexus.repositoriesResource()::getMavenProxyRepository,
                nexus.repositoriesResource()::createMavenProxyRepository
        );
        ensureRepositoryExists(
                nexus,
                "maven2",
                MavenGroupRepositoryForm.builder()
                        .name("maven-public")
                        .storage(RepositoryStorageForm.builder()
                                .blobStoreName(blobStoreName)
                                .build())
                        .group(RepositoryGroupForm.builder()
                                .memberName("maven-central")
                                .memberName("maven-releases")
                                .build())
                        .build(),
                nexus.repositoriesResource()::getMavenGroupRepository,
                nexus.repositoriesResource()::createMavenGroupRepository
        );
        ensureRepositoryExists(
                nexus,
                "raw",
                RawHostedRepositoryForm.builder()
                        .name("raw-releases")
                        .storage(MavenHostedRepositoryStorageForm.builder()
                                .blobStoreName(blobStoreName)
                                .build())
                        .build(),
                nexus.repositoriesResource()::getRawHostedRepository,
                nexus.repositoriesResource()::createRawHostedRepository
        );
        ensureRepositoryExists(
                nexus,
                "docker",
                DockerHostedRepositoryForm.builder()
                        .name("docker-releases")
                        .docker(RepositoryDockerForm.builder()
                                .httpPort(5000)
                                .build())
                        .storage(DockerHostedRepositoryStorageForm.builder()
                                .blobStoreName(blobStoreName)
                                .build())
                        .build(),
                nexus.repositoriesResource()::getDockerHostedRepository,
                nexus.repositoriesResource()::createDockerHostedRepository
        );
    }

    private static String ensureBlobStoreExists(Nexus nexus, String spaceId) {
        try {
            nexus.blobStoresResource().getFileBlobStore(spaceId);
            return spaceId;
        } catch (NotFoundException e) {
            nexus.blobStoresResource().createFileBlobStore(FileBlobStoreForm.builder()
                    .name(spaceId)
                    .path("./" + spaceId)
                    .build());
            return spaceId;
        }
    }

    private <T extends AbstractRepositoryForm> void ensureRepositoryExists(Nexus nexus, String type, T repoForm, Function<String, T> finder, Consumer<T> createor) {
        try {
            finder.apply(repoForm.getName());
        } catch (NotFoundException e) {
            createor.accept(repoForm);
        }
        ensureRolesExist(
                nexus,
                type,
                repoForm.getName(),
                new HashSet<>(Arrays.asList("*", "read", "browse"))
        );
    }

    private static void ensureRolesExist(Nexus nexus, String repoType, String repoNanme, HashSet<String> permissions) {
        ensureRolesExist(
                nexus.rolesResource()
                        .findAll().stream()
                        .filter(rr -> rr.getSource().equalsIgnoreCase("default"))
                        .collect(Collectors.toMap(
                                rr -> rr.getId(),
                                Function.identity()
                        )),
                repoType,
                repoNanme,
                permissions,
                nexus.rolesResource()
        );
    }

    private static void ensureRolesExist(Map<String, RoleRepresentation> rolesById, String repoType, String repoName, Set<String> permissions, RolesResource rolesResource) {
        for (String permission : permissions) {
            String privilege = "nx-repository-view-" + repoType + "-" + repoName + "-" + permission;
            RoleForm roleForm = RoleForm.builder()
                    .id(privilege)
                    .description(privilege)
                    .name(privilege)
                    .privilege(privilege)
                    .build();

            if (rolesById.containsKey(privilege)) {
                rolesResource.update(privilege, roleForm);
            } else {
                rolesResource.create(roleForm);
            }
        }
    }

}
