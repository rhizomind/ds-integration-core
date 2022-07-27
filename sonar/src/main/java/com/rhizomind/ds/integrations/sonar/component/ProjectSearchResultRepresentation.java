package com.rhizomind.ds.integrations.sonar.component;

import com.rhizomind.ds.integrations.sonar.ComponentRepresentation;
import com.rhizomind.ds.integrations.sonar.Paging;
import lombok.Data;

import java.util.List;

@Data
public class ProjectSearchResultRepresentation {

    private Paging paging;
    private List<ComponentRepresentation> components;

}