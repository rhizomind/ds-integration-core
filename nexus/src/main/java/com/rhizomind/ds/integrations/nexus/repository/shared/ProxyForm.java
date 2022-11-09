package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProxyForm {

    @Builder.Default
    private String remoteUrl = "https://repo1.maven.org/maven2/";
    @Builder.Default
    private int contentMaxAge = 1440;
    @Builder.Default
    private int metadataMaxAge = 1440;

}
