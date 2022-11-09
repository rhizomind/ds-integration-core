package com.rhizomind.ds.integrations.nexus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.nexus.blobstore.BlobStoresResource;
import com.rhizomind.ds.integrations.nexus.repository.RepositoriesResource;
import com.rhizomind.ds.integrations.nexus.roles.RolesResource;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.net.URL;

public class Nexus {

    private final ClientFactory clientFactory;

    public Nexus(URL  serverUrl, String username, String token, ClientFactoryBuilder clientFactoryBuilder) {
        ObjectMapper objectMapper = new ObjectMapper()
                .disable(
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                        DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE
                )
                .disable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        SerializationFeature.FAIL_ON_EMPTY_BEANS
                )
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModules(
                        new Jdk8Module(),
                        new JavaTimeModule()
                );


        this.clientFactory = clientFactoryBuilder.build(
                serverUrl.toString()+"service/rest",
                new JacksonJsonProvider(objectMapper),
                new BasicAuthentication(username, token)
        );
    }

    public RepositoriesResource repositoriesResource() {
        return this.clientFactory.create(RepositoriesResource.class);
    }

    public RolesResource rolesResource() {
        return this.clientFactory.create(RolesResource.class);
    }

    public BlobStoresResource blobStoresResource() {
        return this.clientFactory.create(BlobStoresResource.class);
    }

    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    class MyProvider extends JacksonJsonProvider {
        MyProvider(ObjectMapper mapper) {
            super(mapper);
        }
    }
}
