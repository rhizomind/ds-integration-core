package com.rhizomind.ds.integrations.jenkins.jobs;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FolderItemInfoDto.class, name = "com.cloudbees.hudson.plugins.folder.Folder"),
        @JsonSubTypes.Type(value = MultibranchItemInfoDto.class, name = "org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject"),
        @JsonSubTypes.Type(value = JobItemInfoDto.class, name = "org.jenkinsci.plugins.workflow.job.WorkflowJob")
})
@Data
public class ItemInfoDto {

    private String description;
    private String displayName;
    private String displayNameOrNull;
    private String fullDisplayName;
    private String fullName;
    private String name;
    private String url;
    private List<ItemInfoDto> jobs;

}
