package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractRepositoryForm {

    private String name;
    @Builder.Default
    private boolean online = true;

    public abstract String getType();

}
