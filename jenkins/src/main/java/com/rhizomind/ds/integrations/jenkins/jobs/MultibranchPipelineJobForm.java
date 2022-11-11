package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Data;

@Data
public class MultibranchPipelineJobForm {

    private boolean enable = true;
    private String displayNameOrNull = "";
    private String description = "";

    private MultibranchPipelineSource sources;

    private ProjectFactory projectFactory = new ProjectFactory();

    private OrphanedItemStrategy orphanedItemStrategy = new OrphanedItemStrategy();

    private Icon icon = new Icon();

    public MultibranchPipelineJobForm(MultibranchPipelineSource sources) {
        this.sources = sources;
    }
}
