package com.rhizomind.ds.integrations.jenkins.credentials;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class SSHUsernameCredentialsForm {

    private final String id;
    private final String username;
    private final boolean usernameSecret;
    private final String description;
    private final SSHPrivateKeySourceForm privateKeySource;
    @JsonProperty("stapler-class")
    private final String staplerClass = "com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey";

}
