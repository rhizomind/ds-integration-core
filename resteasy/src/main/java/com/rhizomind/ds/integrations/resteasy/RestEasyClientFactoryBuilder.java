package com.rhizomind.ds.integrations.resteasy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhizomind.ds.integrations.ClientFactory;
import com.rhizomind.ds.integrations.ClientFactoryBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.ws.rs.client.ClientRequestFilter;

public class RestEasyClientFactoryBuilder implements ClientFactoryBuilder {

    @Override
    public ClientFactory build(String serverUrl, Object jsonMapperProvider, ClientRequestFilter interceptor) {
        ResteasyClientBuilderImpl clientBuilder = new ResteasyClientBuilderImpl()
                .register(jsonMapperProvider)
                .register(interceptor);

        return clientBuilder
                .build()
                .target(serverUrl)::proxy;
    }
}
