package com.rhizomind.ds.integrations.nexus.repository.docker;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryDockerForm {

    @Builder.Default
    private boolean v1Enabled = false;
    @Builder.Default
    private boolean forceBasicAuth = true;
    @Builder.Default
    private Integer httpPort = 5000;
    private Integer httpsPort;
    private String subdomain;

}
