package com.rhizomind.ds.integrations.nexus.blobstore;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class BlobStoreRepresentation {

    private String name;
    private String type;
    private int blobCount;
    private boolean unavailable;
    private long totalSizeInBytes;
    private long availableSpaceInBytes;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unmappedProperties = new HashMap<>();


}
