package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NegativeCacheForm {

    @Builder.Default
    private boolean enabled = true;
    @Builder.Default
    private int timeToLive = 1440;

}
