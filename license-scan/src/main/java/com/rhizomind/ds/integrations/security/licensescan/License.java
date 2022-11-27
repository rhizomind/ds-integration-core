package com.rhizomind.ds.integrations.security.licensescan;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class License {

    private String name;
    private String url;

}
