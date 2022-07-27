package com.rhizomind.ds.integrations.sonar.projectanalysis;

import com.rhizomind.ds.integrations.sonar.Paging;
import lombok.Data;

import java.util.List;

@Data
public class ProjectAnalysesSearchResultRepresentation {

    private Paging paging;
    private List<ProjectAnalysisRepresentation> analyses;

}