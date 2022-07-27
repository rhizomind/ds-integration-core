package com.rhizomind.ds.integrations.jira.server.projectcategory;

import lombok.Data;
import lombok.ToString;

import java.net.URL;

@Data
@ToString
public class ProjectCategoryRepresentation {

    private String id;
    private String name;
    private String description;
    private URL self;

}
