package com.rhizomind.ds.integrations.jenkins.jobs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FolderForm {

    private String displayNameOrNull;
    private String description;
    private Icon icon = new Icon();
    @JsonProperty("core:apply")
    private String coreApply = "";

}
