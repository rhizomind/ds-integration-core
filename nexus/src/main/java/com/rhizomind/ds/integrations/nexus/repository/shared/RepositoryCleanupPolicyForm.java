package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryCleanupPolicyForm {

    @Builder.Default
    private Set<String> policyNames = new HashSet<>();

}
