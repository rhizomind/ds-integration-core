package com.rhizomind.ds.integrations.bitbucket.cloud.workspace;

import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class WorkspaceRepresentation {

    private String type;
    private String uuid;
    private String slug;
    private String name;

    private Map<String, List<LinkRepresentation>> links;
}
