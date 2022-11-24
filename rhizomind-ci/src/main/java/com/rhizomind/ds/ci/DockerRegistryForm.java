package com.rhizomind.ds.ci;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DockerRegistryForm {

    private String url;
    private String credentialsId;

}
