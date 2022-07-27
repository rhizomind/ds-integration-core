package com.rhizomind.ds.integrations.jira.server.status;

import lombok.Data;

import java.net.URL;

@Data
public class StatusRepresentation {

    private String id;
    private String name;
    private String description;
    private URL self;
    private URL iconUrl;

    private StatusCategoryRepresentation statusCategory;

}
