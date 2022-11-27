package com.rhizomind.ds.integrations.security.licensescan;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DependencyLicensesSummary {

    private List<License> licenses;

    private List<DependencyLicenses> dependencyLicenses;

}
