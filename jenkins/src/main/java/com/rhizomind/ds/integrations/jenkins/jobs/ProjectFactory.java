package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectFactory extends JenkinsDto {

    private String scriptPath;

    public ProjectFactory() {
        super("org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory");
    }
}
