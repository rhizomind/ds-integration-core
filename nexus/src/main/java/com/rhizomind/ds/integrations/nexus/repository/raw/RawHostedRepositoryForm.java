package com.rhizomind.ds.integrations.nexus.repository.raw;

import com.rhizomind.ds.integrations.nexus.repository.shared.AbstractRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryCleanupPolicyForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryComponentForm;
import com.rhizomind.ds.integrations.nexus.repository.maven.MavenHostedRepositoryStorageForm;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class RawHostedRepositoryForm  extends AbstractRepositoryForm {

    private MavenHostedRepositoryStorageForm storage;
    @Builder.Default
    private RepositoryCleanupPolicyForm cleanup = RepositoryCleanupPolicyForm.builder().build();
    @Builder.Default
    private RepositoryComponentForm component = RepositoryComponentForm.builder().build();
    @Builder.Default
    private RepositoryRawForm raw = RepositoryRawForm.builder().build();

}
