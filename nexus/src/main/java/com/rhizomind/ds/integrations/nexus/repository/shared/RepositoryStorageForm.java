package com.rhizomind.ds.integrations.nexus.repository.shared;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryStorageForm {

    private String blobStoreName;
    @Builder.Default
    private boolean strictContentTypeValidation = true;


}
