package com.rhizomind.ds.integrations.nexus.repository.maven;

import com.rhizomind.ds.integrations.nexus.repository.shared.AbstractRepositoryForm;
import com.rhizomind.ds.integrations.nexus.repository.shared.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class MavenProxyRepositoryForm extends AbstractRepositoryForm {

    private RepositoryStorageForm storage;
    @Builder.Default
    private RepositoryCleanupPolicyForm cleanup = RepositoryCleanupPolicyForm.builder().build();
    @Builder.Default
    private ProxyForm proxy = ProxyForm.builder().build();
    @Builder.Default
    private NegativeCacheForm negativeCache = NegativeCacheForm.builder().build();
    @Builder.Default
    private HttpClientForm httpClient = HttpClientForm.builder().build();
    private String routingRule;
    // replication?
    @Builder.Default
    private RepositoryMavenForm maven = RepositoryMavenForm.builder().build();

}
