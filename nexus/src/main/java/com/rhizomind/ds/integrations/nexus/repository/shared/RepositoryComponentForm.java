package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryComponentForm {

    @Builder.Default
    private boolean proprietaryComponents = true;

}
