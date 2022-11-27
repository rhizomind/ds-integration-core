package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhizomind.ds.integrations.security.licensescan.ComponentId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ComponentIdDeserializerTest {

    @Test
    void name() throws JsonProcessingException {
        ComponentId componentId = new ObjectMapper().readValue("\"com.oracle.database.jdbc:ucp:11.2.0.4\"", ComponentId.class);

        Assertions.assertEquals("com.oracle.database.jdbc", componentId.getGroupId());
        Assertions.assertEquals("ucp", componentId.getArtifactID());
        Assertions.assertEquals("11.2.0.4", componentId.getVersion());
    }
}
