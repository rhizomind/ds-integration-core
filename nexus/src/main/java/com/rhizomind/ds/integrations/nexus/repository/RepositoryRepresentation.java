package com.rhizomind.ds.integrations.nexus.repository;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.ToString;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class RepositoryRepresentation {

    private String name;
    private String format;
    private String type;
    private URL url;
    private Map<String, Object> attributes;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();


}
