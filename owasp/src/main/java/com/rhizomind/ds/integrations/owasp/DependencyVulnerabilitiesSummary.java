package com.rhizomind.ds.integrations.owasp;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class DependencyVulnerabilitiesSummary {

    private ComponentId componentId;
    private ZonedDateTime reportDate;

    private List<VulnerableDependency> vulnerableDependencies;

}
