package com.rhizomind.ds.integrations.docker;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Map;

@Data
@Builder
public class DockerConfig {

    @Singular
    private Map<String, RegistryAuth> auths ;

}
