package com.rhizomind.ds.integrations.owasp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponentId {
    private String groupId;
    private String artifactId;
    private String version;

}
