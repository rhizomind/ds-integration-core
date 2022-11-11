package com.rhizomind.ds.integrations.bitbucket.cloud;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class UserRepresentation {

    private String type;
    private String uuid;
    private String nickname;
    @JsonProperty("display_name")
    private String displayName;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
