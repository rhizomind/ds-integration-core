package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultibranchPipelineSource extends JenkinsDto {

    private ScmSource source;
    private JenkinsDto strategy;
    private String kind;

    public static MultibranchPipelineSource bitbucketRepo(String apiTokenCredentialsId, String sshKeyCredentialsId, String repoOwner, String repoName) {
        MultibranchPipelineSource result = new MultibranchPipelineSource();
        result.setSource(ScmSource.bitbucketCloudRepo(apiTokenCredentialsId, sshKeyCredentialsId, repoOwner, repoName));
        result.setStrategy(new JenkinsDto("jenkins.branch.DefaultBranchPropertyStrategy"));
        result.setKind("jenkins.branch.BranchSource");
        return result;
    }

    public MultibranchPipelineSource() {
        super("jenkins.branch.BranchSource");
    }

}
