package com.rhizomind.ds.integrations.nexus.roles;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@ToString
public class RoleRepresentation {

    private String id;
    private String source;
    private String name;
    private String description;
    private Boolean readOnly;

    private Set<String> privileges;
    private Set<String> roles;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();

}
