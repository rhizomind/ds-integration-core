package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrphanedItemStrategy extends JenkinsDto {

    private Boolean abortBuilds = false;
    private Boolean pruneDeadBrunched = true;
    private String daysToKeepStr = "";
    private String numToKeepStr = "";

    public OrphanedItemStrategy() {
        super("com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy");
    }

}
