package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rhizomind.ds.integrations.security.licensescan.ComponentId;
import com.rhizomind.ds.integrations.security.licensescan.License;
import lombok.Data;

import java.util.Set;

@Data
public class DependencyLicenses {

    @JsonDeserialize(using = DependencyDeserializer.class)
    private ComponentId name;
    private String file;
    private Set<License> licenses;

}
