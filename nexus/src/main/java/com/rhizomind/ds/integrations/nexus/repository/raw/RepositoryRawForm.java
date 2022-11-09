package com.rhizomind.ds.integrations.nexus.repository.raw;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryRawForm {

    @Builder.Default
    private String contentDisposition = "ATTACHMENT";

}
