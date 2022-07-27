package com.rhizomind.ds.integrations.jira.server.status;

import lombok.Data;

import java.net.URL;

@Data
public class StatusCategoryRepresentation {

    private String id;
    private String name;
    private String key;
    private String colorName;
    private URL self;


}
