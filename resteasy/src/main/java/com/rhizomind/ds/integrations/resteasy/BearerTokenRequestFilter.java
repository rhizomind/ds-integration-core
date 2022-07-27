package com.rhizomind.ds.integrations.resteasy;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class BearerTokenRequestFilter implements ClientRequestFilter {
    private String token;

    public BearerTokenRequestFilter(String token) {
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().putSingle("Authorization", "Bearer " + token);
    }
}
