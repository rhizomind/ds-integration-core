package com.rhizomind.ds.integrations.nexus.repository.maven;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MavenHostedRepositoryStorageForm {

    private String blobStoreName;
    @Builder.Default
    private boolean strictContentTypeValidation = true;
    @Builder.Default
    private String writePolicy = "allow_once";

}
