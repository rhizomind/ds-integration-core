package com.rhizomind.ds.integrations.jira.server.resolution;

import com.rhizomind.ds.integrations.jira.server.status.StatusCategoryRepresentation;
import lombok.Data;

import java.net.URL;

@Data
public class ResolutionRepresentation {

    private String name;
    private String description;
    private URL self;
    private URL iconUrl;

}
