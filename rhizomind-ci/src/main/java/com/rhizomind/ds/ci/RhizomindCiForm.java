package com.rhizomind.ds.ci;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RhizomindCiForm {

    private String clientId;
    private String ciNamespace;
    private String mavenSettingsConfigFileId;
    @Singular
    private Map<String, MavenRegistryForm> mavenRegistries = new HashMap<>();
    @Singular
    private Map<String, DockerRegistryForm> dockerRegistries = new HashMap<>();
    @Singular
    private Map<String, SonarServerForm> sonarServers = new HashMap<>();
    @Singular
    private Map<String, DependencyCheckDbForm> dependencyCheckDbs = new HashMap<>();
    @Singular
    private Map<String, DeploymentTargetForm> deploymentTargets = new HashMap<>();
}
