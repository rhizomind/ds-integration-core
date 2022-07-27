package com.rhizomind.ds.integrations.sonar.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class SystemInfoRepresentation {

    @JsonProperty("Statistics")
    private JsonNode statistics;
    @JsonProperty("Database")
    private JsonNode database;
    @JsonProperty("JvmProperties")
    private JsonNode jvmProperties;
    @JsonProperty("Plugins")
    private JsonNode plugins;
    @JsonProperty("Nodes")
    private JsonNode nodes;
    @JsonProperty("ElasticSearch")
    private JsonNode elasticSearch;
    @JsonProperty("SonarQube")
    private JsonNode sonarQube;
    @JsonProperty("System")
    private JsonNode system;

}
