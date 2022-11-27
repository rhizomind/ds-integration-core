package com.rhizomind.ds.integrations.security.licensescan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rhizomind.ds.integrations.security.licensescan.hieronymus.DependencyDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Comparator;

@Data
@JsonDeserialize(using = DependencyDeserializer.class)
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ComponentId implements Comparable<ComponentId> {

    private final String groupId;
    private final String artifactID;
    private final String version;

    @Override
    public int compareTo(ComponentId o) {
        return Comparator
                .comparing(ComponentId::getGroupId)
                .thenComparing(ComponentId::getArtifactID)
                .thenComparing(ComponentId::getVersion)
                .compare(this, o);
    }
}
