package com.rhizomind.ds.integrations.sonar.system;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.List;

@Data
public class SystemHealthRepresentation {

    private String health;
    private List<JsonNode> causes;
    private List<JsonNode> nodes;

}
