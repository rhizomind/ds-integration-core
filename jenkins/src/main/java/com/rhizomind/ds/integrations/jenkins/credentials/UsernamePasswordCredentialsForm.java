package com.rhizomind.ds.integrations.jenkins.credentials;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UsernamePasswordCredentialsForm {
    private final String id;
    private final String username;
    private final String password;
    private final boolean usernameSecret;
    private final String description;
    @JsonProperty("stapler-class")
    private final String staplerClass = "com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl";

}
