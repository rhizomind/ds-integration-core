package com.rhizomind.ds.integrations.owasp;

import com.rhizomind.ds.integrations.owasp.v25.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.ZonedDateTime.parse;
import static java.util.Comparator.*;

public class DependencyVulnerabilitiesReader {

    private final static JAXBContext OWASP_DEPENDENCY_CHECK_2_5_CONTEXT;

    static {
        try {
            OWASP_DEPENDENCY_CHECK_2_5_CONTEXT = JAXBContext.newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Analysis readMavenDependencyVulnerabilitiesReport(InputStream resourceAsStream) throws JAXBException {
        Unmarshaller unmarshaller = OWASP_DEPENDENCY_CHECK_2_5_CONTEXT.createUnmarshaller();
        return (Analysis) unmarshaller.unmarshal(resourceAsStream);
    }

    public DependencyVulnerabilitiesSummary readSummary(InputStream inputStream) throws JAXBException {
        return toSummary(readMavenDependencyVulnerabilitiesReport(inputStream));
    }

    public DependencyVulnerabilitiesSummary toSummary(Analysis input) {
        DependencyVulnerabilitiesSummary result = new DependencyVulnerabilitiesSummary();

        ProjectInfo projectInfo = input.getProjectInfo();
        result.setComponentId(createComponentId(projectInfo));
        result.setReportDate(parse(projectInfo.getReportDate()));

        result.setVulnerableDependencies(
                input.getDependencies().getDependency().stream()
                        .filter(e -> e.getIdentifiers() != null)
                        .filter(e -> e.getVulnerabilities() != null)
                        .map(d -> {
                            List<Vulnerability> vulnerabilities = createVulnerabilities(d.getVulnerabilities());
                            Optional<VulnerabilitySeverity> vulnerabilitySeverity = vulnerabilities.stream().map(Vulnerability::getBaseSeverity).map(VulnerabilitySeverity::getValue).sorted(reverseOrder()).map(VulnerabilitySeverity::parse).findFirst();
                            return VulnerableDependency.builder()
                                    .componentId(createComponentId(d.getIdentifiers()))
                                    .vulnerabilities(vulnerabilities)
                                    .highestSeverity(vulnerabilitySeverity.orElse(null))
                                    .build();
                        })
                        .collect(Collectors.toList())
        );

        return result;
    }

    private List<Vulnerability> createVulnerabilities(Dependency.Vulnerabilities vulnerabilities) {
        if (vulnerabilities != null && !vulnerabilities.getVulnerability().isEmpty()) {
            return vulnerabilities.getVulnerability()
                    .stream()
                    .map(v -> createVulnerability(v))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static Vulnerability createVulnerability(com.rhizomind.ds.integrations.owasp.v25.Vulnerability v) {
        Vulnerability.VulnerabilityBuilder builder = Vulnerability.builder()
                .description(v.getDescription());
        if (v.getCvssV3() != null) {
            return builder
                    .baseScore(v.getCvssV3().getBaseScore())

                    .attackVector(v.getCvssV3().getAttackVector())
                    .attackComplexity(v.getCvssV3().getAttackComplexity())
                    .baseSeverity(VulnerabilitySeverity.parse(v.getCvssV3().getBaseSeverity()))
                    .availabilityImpact(v.getCvssV3().getAvailabilityImpact())
                    .confidentialityImpact(v.getCvssV3().getConfidentialityImpact())
                    .impactScore(v.getCvssV3().getImpactScore())
                    .privilegesRequired(v.getCvssV3().getPrivilegesRequired())
                    .exploitabilityScore(v.getCvssV3().getExploitabilityScore())
                    .availabilityImpact(v.getCvssV3().getAvailabilityImpact())
                    .build();
        }
        return builder.build();
    }

    private ComponentId createComponentId(Dependency.Identifiers identifiers) {
        Optional<Identifier> mavenIdentifier = identifiers.getPackage()
                .stream().filter(i -> i.getId().startsWith("pkg:maven"))
                .findFirst();

        return mavenIdentifier
                .map(id -> {
                    String id1 = id.getId();
                    String[] split1 = id1.split("/");
                    String[] split2 = split1[2].split("@");
                    return ComponentId.builder()
                            .groupId(split1[1])
                            .artifactId(split2[0])
                            .version(split2[1])
                            .build();
                })
                .orElseThrow(() -> new RuntimeException("couldn't find recognizable identifier of  this dependency"));
    }

    private static ComponentId createComponentId(ProjectInfo projectInfo) {
        return ComponentId.builder()
                .artifactId(projectInfo.getArtifactID())
                .groupId(projectInfo.getGroupID())
                .version(projectInfo.getVersion())
                .build();
    }
}
