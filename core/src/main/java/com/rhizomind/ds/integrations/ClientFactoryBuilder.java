package com.rhizomind.ds.integrations;

import javax.ws.rs.client.ClientRequestFilter;

public interface ClientFactoryBuilder {

    ClientFactory build(String serverUrl, Object jsonMapperProvider, ClientRequestFilter requestFilter);

}
