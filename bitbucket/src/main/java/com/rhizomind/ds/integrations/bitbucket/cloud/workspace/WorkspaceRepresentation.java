package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WorkspaceRepresentation {

    private String type;
    private String uuid;
    private String slug;
    private String name;

    private WorkspaceLinksRepresentation links;
}
