package com.rhizomind.ds.integrations.sonar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.sonar.component.ComponentsResource;
import com.rhizomind.ds.integrations.sonar.measures.MeasuresResource;
import com.rhizomind.ds.integrations.sonar.metric.MetricsResource;
import com.rhizomind.ds.integrations.sonar.projectanalysis.ProjectAnalysesResource;
import com.rhizomind.ds.integrations.sonar.system.SystemResource;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

public class SonarServer {

    private final ClientFactory clientFactory;

    public SonarServer(String serverUrl, String token, ClientFactoryBuilder clientFactoryBuilder) {
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
                new BasicAuthentication(token, "")
        );
    }

    public ComponentsResource components(){
        return this.clientFactory.create(ComponentsResource.class);
    }
    public MeasuresResource measures(){
        return this.clientFactory.create(MeasuresResource.class);
    }
    public MetricsResource metricsResource(){
        return this.clientFactory.create(MetricsResource.class);
    }
    public ProjectAnalysesResource projectAnalyses(){
        return this.clientFactory.create(ProjectAnalysesResource.class);
    }
    public SystemResource system(){
        return this.clientFactory.create(SystemResource.class);
    }

}
