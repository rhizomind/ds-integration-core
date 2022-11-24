package com.rhizomind.ds.ci;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeploymentTargetForm {

    @Singular
    private List<String> namespaces;
    private String credentialsId;

}
