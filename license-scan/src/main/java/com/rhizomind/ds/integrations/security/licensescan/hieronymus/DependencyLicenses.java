package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import lombok.Data;

import java.util.Set;

@Data
public class DependencyLicenses {

    private DependencyId name;
    private String file;
    private Set<License> licenses;

}
