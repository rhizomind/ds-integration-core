package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ScmSource extends JenkinsDto {

    private String id;
    private String serverUrl;
    private String credentialsId;
    private String repoOwner;
    private String repository ;
    private boolean includeUser = false;
    private List<ScmSourceTrait> traits;

    public static  ScmSource bitbucketCloudRepo(String apiTokenCredentialsId, String sshKeyCredentialsId,  String repoOwner, String repository) {
        ScmSource scmSource = new ScmSource();
        scmSource.setServerUrl("https://bitbucket.org/");
        scmSource.setCredentialsId( apiTokenCredentialsId);
        scmSource.setRepoOwner(repoOwner);
        scmSource.setRepository(repository);
        scmSource.setTraits(Arrays.asList(
                        new ScmSourceTrait("com.cloudbees.jenkins.plugins.bitbucket.BranchDiscoveryTrait"),
                        new ScmSourceTrait("com.cloudbees.jenkins.plugins.bitbucket.OriginPullRequestDiscoveryTrait"),
                        new CheckoutOverSSHSourceTrait(sshKeyCredentialsId)
        ));
        return scmSource;
    }

    public ScmSource() {
        super("com.cloudbees.jenkins.plugins.bitbucket.BitbucketSCMSource");
    }
}
