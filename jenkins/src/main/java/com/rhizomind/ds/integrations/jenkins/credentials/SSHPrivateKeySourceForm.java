package com.rhizomind.ds.integrations.jenkins.credentials;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class SSHPrivateKeySourceForm {

    private final String value = "0";

    private String privateKey;

    @JsonProperty("stapler-class")
    private final String staplerClass = "com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey$DirectEntryPrivateKeySource";


}
