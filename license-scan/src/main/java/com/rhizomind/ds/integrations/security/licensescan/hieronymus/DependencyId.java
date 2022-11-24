package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonDeserialize(using = DependencyDeserializer.class)
@AllArgsConstructor
public class DependencyId {

    private final String groupId;
    private final String artifactID;
    private final String version;

}
