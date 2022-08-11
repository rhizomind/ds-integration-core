package com.rhizomind.ds.integrations.jenkins.system;

import lombok.Data;
import lombok.Value;

import javax.ws.rs.core.Response;

@Value
public class SystemInfo {

    private String hudsonVersion;
    private String jenkinsVersion;
    private String jenkinsSession;
    private String instanceIdentity;
    private String sshEndpoint;
    private String server;

    public static SystemInfo read(Response response) {
        return new SystemInfo(
                response.getHeaderString("X-Hudson"),
                response.getHeaderString("X-Jenkins"),
                response.getHeaderString("X-Jenkins-Session"),
                response.getHeaderString("X-Instance-Identity"),
                response.getHeaderString("X-SSH-Endpoint"),
                response.getHeaderString("X-Server")
        );
    }

}