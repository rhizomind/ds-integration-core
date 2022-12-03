package com.rhizomind.ds.integrations.bitbucket.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.bitbucket.server.projects.ProjectsResource;
import com.rhizomind.ds.integrations.bitbucket.server.serverinfo.ApplicationPropertiesResource;
import com.rhizomind.ds.integrations.bitbucket.server.users.UsersResource;
import com.rhizomind.ds.integrations.BearerTokenRequestFilter;

public class BitbucketServer {

    private final ClientFactory clientFactory;

    public BitbucketServer(String serverUrl, String token, ClientFactoryBuilder clientFactoryBuilder) {
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
                serverUrl,
                new JacksonJsonProvider(objectMapper),
                new BearerTokenRequestFilter(token)
        );
    }

    public ApplicationPropertiesResource systemResource() {
        return this.clientFactory.create(ApplicationPropertiesResource.class);
    }

    public ProjectsResource projectsResource() {
        return this.clientFactory.create(ProjectsResource.class);
    }

    public UsersResource usersResource() {
        return this.clientFactory.create(UsersResource.class);
    }

}
