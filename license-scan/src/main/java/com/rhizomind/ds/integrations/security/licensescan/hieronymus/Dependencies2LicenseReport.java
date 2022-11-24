package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import lombok.Data;

import java.util.List;

@Data
public class Dependencies2LicenseReport {

    private List<DependencyLicenses> dependencies;

}
