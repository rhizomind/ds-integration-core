
package com.rhizomind.ds.integrations.jira.cloud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import com.rhizomind.ds.integrations.jira.server.issue.IssuesResource;
import com.rhizomind.ds.integrations.jira.server.issuetype.IssueTypesResource;
import com.rhizomind.ds.integrations.jira.server.project.ProjectsResource;
import com.rhizomind.ds.integrations.jira.server.serverinfo.ServerInfoResource;
import com.rhizomind.ds.integrations.jira.server.version.VersionsResource;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.net.URL;
import java.util.Objects;

public class JiraCloud {

    private final ClientFactory clientFactory;

    public JiraCloud(URL  apiUrl, String username, String token, ClientFactoryBuilder clientFactoryBuilder) {
        Objects.requireNonNull(apiUrl, "apiUr ust not be null");
        Objects.requireNonNull(username, "username ust not be null");
        Objects.requireNonNull(token, "token  ust not be null");
        Objects.requireNonNull(clientFactoryBuilder, "clientFactoryBuilder ust not be null");
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

    public ServerInfoResource serverInfoResource(){
        return this.clientFactory.create(ServerInfoResource.class);
    }

    public ProjectsResource projectsResource(){
        return this.clientFactory.create(ProjectsResource.class);
    }

    public IssueTypesResource issueTypesResource(){
        return this.clientFactory.create(IssueTypesResource.class);
    }

    public VersionsResource versionsResource(){
        return this.clientFactory.create(VersionsResource.class);
    }

    public IssuesResource issuesResource() {
        return this.clientFactory.create(IssuesResource.class);
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
