package com.rhizomind.ds.integrations.bitbucket.cloud.projects;

import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class ProjectRepresentation {

    private String type;
    private String key;
    private String uuid;
    private String name;

    private Map<String, List<LinkRepresentation>> links;

}
