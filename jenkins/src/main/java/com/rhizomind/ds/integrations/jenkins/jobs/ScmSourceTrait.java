package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScmSourceTrait  extends JenkinsDto{

    private String strategyId = "1";
    public ScmSourceTrait(String staplerClass) {
        super(staplerClass);
    }
}
