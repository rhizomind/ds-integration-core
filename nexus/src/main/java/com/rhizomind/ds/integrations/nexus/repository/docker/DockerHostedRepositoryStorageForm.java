package com.rhizomind.ds.integrations.nexus.repository.docker;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DockerHostedRepositoryStorageForm {

    private String blobStoreName;
    @Builder.Default
    private boolean strictContentTypeValidation = true;
    @Builder.Default
    private String writePolicy = "allow";
    @Builder.Default
    private boolean latestPolicy = true;

}
