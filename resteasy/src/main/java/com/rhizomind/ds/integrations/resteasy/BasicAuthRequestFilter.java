package com.rhizomind.ds.integrations.resteasy;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthRequestFilter implements ClientRequestFilter {

    private final String headerValue;

    public BasicAuthRequestFilter(String username, String password) {
        StringBuffer buf = new StringBuffer(username);
        buf.append(':').append(password);
        this.headerValue = "Basic " + Base64.getEncoder().encodeToString(buf.toString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().putSingle("Authorization", headerValue);
    }
}
