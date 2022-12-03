package com.rhizomind.ds.integrations.gitlab;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProjectRepresentation {

    private String id;

    @JsonAnyGetter
    @JsonAnySetter
    private Map<String, Object> unknownFields = new HashMap<>();
    @JsonProperty("path_with_namespace")
    private String pathWithNamespace;
    @JsonProperty("name_with_namespace")
    private String nameWithNamespace;
    @JsonProperty("ssh_url_to_repo")
    private String sshUrlToRepo;
    @JsonProperty("http_url_to_repo")
    private String httpUrlToRepo;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("default_branch")
    private String defaultBranch;

}
