package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HttpClientForm {

    @Builder.Default
    private boolean blocked = false;
    @Builder.Default
    private boolean autoBlock = true;

}
