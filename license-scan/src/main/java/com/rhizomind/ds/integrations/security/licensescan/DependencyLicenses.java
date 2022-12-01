package com.rhizomind.ds.integrations.security.licensescan;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode
@Builder
public class DependencyLicenses {

    private ComponentId componentId;
    private Set<String> licenses;

}
