package com.rhizomind.ds.integrations.jenkins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.jenkins.system.SystemApi;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import java.net.URL;

public class Jenkins {

    private final ClientFactory clientFactory;

    public Jenkins(URL apiUrl, String username, String token, ClientFactoryBuilder clientFactoryBuilder) {
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
                apiUrl.toString(),
                new JacksonJsonProvider(objectMapper),
                new BasicAuthentication(username, token)
        );
    }


    public SystemApi system(){
        return this.clientFactory.create(SystemApi.class);
    }

    public FoldersApi folders(){
        return this.clientFactory.create(FoldersApi.class);
    }

}
