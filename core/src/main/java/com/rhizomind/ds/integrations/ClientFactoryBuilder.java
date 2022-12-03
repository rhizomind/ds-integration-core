package com.rhizomind.ds.integrations;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.ClientRequestFilter;

public interface ClientFactoryBuilder {

    ClientFactory build(String serverUrl, JacksonJsonProvider jsonMapperProvider, ClientRequestFilter requestFilter);

}
