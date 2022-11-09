package com.rhizomind.ds.integrations.nexus.repository.maven;

import com.rhizomind.ds.integrations.nexus.repository.shared.AbstractRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryGroupForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryStorageForm;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class MavenGroupRepositoryForm extends AbstractRepositoryForm {

    private RepositoryStorageForm storage;
    @Builder.Default
    private RepositoryGroupForm group = RepositoryGroupForm.builder().build();

}
