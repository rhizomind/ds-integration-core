package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutOverSSHSourceTrait extends ScmSourceTrait {

    private boolean includeUser = false;
    private String credentialsId;

    public CheckoutOverSSHSourceTrait(String credentialsId) {
        super("com.cloudbees.jenkins.plugins.bitbucket.SSHCheckoutTrait");
        this.credentialsId = credentialsId;
    }
}
