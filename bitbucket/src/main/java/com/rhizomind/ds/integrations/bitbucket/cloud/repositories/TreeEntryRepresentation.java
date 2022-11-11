package com.rhizomind.ds.integrations.bitbucket.cloud.repositories;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class TreeEntryRepresentation {

    private String path;

    private String type;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
