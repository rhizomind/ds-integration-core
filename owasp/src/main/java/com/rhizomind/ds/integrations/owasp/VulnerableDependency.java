package com.rhizomind.ds.integrations.owasp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VulnerableDependency {

    private ComponentId componentId;
    private List<Vulnerability> vulnerabilities;
    private VulnerabilitySeverity highestSeverity;

}
