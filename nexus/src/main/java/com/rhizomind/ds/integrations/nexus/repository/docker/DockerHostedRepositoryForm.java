package com.rhizomind.ds.integrations.nexus.repository.docker;

import com.rhizomind.ds.integrations.nexus.repository.shared.AbstractRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryCleanupPolicyForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.RepositoryComponentForm;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class DockerHostedRepositoryForm extends AbstractRepositoryForm {

    @Builder.Default
    private DockerHostedRepositoryStorageForm storage = DockerHostedRepositoryStorageForm.builder().build();
    @Builder.Default
    private RepositoryCleanupPolicyForm cleanup = RepositoryCleanupPolicyForm.builder().build();
    @Builder.Default
    private RepositoryComponentForm component = RepositoryComponentForm.builder().build();
    @Builder.Default
    private RepositoryDockerForm docker = RepositoryDockerForm.builder().build();

}
