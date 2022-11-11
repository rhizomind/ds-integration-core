package com.rhizomind.ds.integrations.jenkins.jobs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JenkinsDto {

    @JsonProperty("stampler-class")
    private String staplerClass;

    @JsonProperty("$class")
    private String clazz;

    public JenkinsDto(String staplerClass) {
        this.staplerClass = staplerClass;
        this.clazz = staplerClass;
    }
}
