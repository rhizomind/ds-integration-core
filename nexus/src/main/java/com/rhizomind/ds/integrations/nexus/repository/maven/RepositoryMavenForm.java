package com.rhizomind.ds.integrations.nexus.repository.maven;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryMavenForm {

    @Builder.Default
    private String versionPolicy = "RELEASE";
    @Builder.Default
    private String layoutPolicy = "STRICT";
    @Builder.Default
    private String contentDisposition = "ATTACHMENT";

}
