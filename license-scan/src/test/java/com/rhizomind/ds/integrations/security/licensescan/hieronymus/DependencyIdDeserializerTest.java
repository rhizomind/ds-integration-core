package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DependencyIdDeserializerTest {

    @Test
    void name() throws JsonProcessingException {
        DependencyId dependencyId = new ObjectMapper().readValue("\"com.oracle.database.jdbc:ucp:11.2.0.4\"", DependencyId.class);

        Assertions.assertEquals("com.oracle.database.jdbc", dependencyId.getGroupId());
        Assertions.assertEquals("ucp", dependencyId.getArtifactID());
        Assertions.assertEquals("11.2.0.4", dependencyId.getVersion());
    }
}
