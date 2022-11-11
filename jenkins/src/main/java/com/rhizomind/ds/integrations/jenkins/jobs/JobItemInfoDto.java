package com.rhizomind.ds.integrations.jenkins.jobs;

import lombok.Data;

import java.util.List;

@Data
public class JobItemInfoDto extends ItemInfoDto {

    private boolean buildable;
    private String color;
    private boolean inQueue;
    private int nextBuildNumber;
    private List<BuildInfoDto> build;

}
