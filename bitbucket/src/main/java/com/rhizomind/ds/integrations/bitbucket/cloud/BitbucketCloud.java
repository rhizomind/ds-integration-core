package com.rhizomind.ds.integrations.bitbucket.cloud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.bitbucket.cloud.repositories.RepositoriesResource;
import com.rhizomind.ds.integrations.bitbucket.cloud.workspace.WorkspacesResource;
import com.rhizomind.ds.integrations.resteasy.BasicAuthRequestFilter;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

public class BitbucketCloud {

    private final ClientFactory clientFactory;

    public BitbucketCloud(String username, String appPassword, ClientFactoryBuilder clientFactoryBuilder) {
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
                "https://api.bitbucket.org",
                new MyProvider(objectMapper),
                new BasicAuthRequestFilter(username, appPassword)
        );

    }

    public WorkspacesResource workspacesResource(){
        return this.clientFactory.create(WorkspacesResource.class);
    }

    public RepositoriesResource repositoriesResource(){
        return this.clientFactory.create(RepositoriesResource.class);
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
