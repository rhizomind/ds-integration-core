package com.rhizomind.ds.integrations.security.licensescan.maven;

import com.rhizomind.ds.integrations.security.licensescan.ComponentId;
import com.rhizomind.ds.integrations.security.licensescan.DependencyLicenses;
import com.rhizomind.ds.integrations.security.licensescan.DependencyLicensesSummary;
import com.rhizomind.ds.integrations.security.licensescan.License;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class DependencyLicensesReader {

    private final JAXBContext context;

    {
        try {
            context = JAXBContext.newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public LicenseSummaryType readMavenDependencyLicenseReport(InputStream inputStream) throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return ((JAXBElement<LicenseSummaryType>) unmarshaller.unmarshal(
                inputStream
        )).getValue();
    }

    public DependencyLicensesSummary readSummary(InputStream inputStream) throws JAXBException {
        return toSummary(readMavenDependencyLicenseReport(inputStream));
    }

    private DependencyLicensesSummary toSummary(LicenseSummaryType input) {
        return DependencyLicensesSummary.builder()
                .licenses(input.getDependencies().getDependency()
                        .stream()
                        .filter(d -> d.getLicenses() != null)
                        .filter(d -> d.getLicenses().getLicense() != null)
                        .flatMap(d -> d.getLicenses().license.stream())
                        .map(l -> createLicense(l))
                        .collect(Collectors.toSet())
                        .stream()
                        .sorted(Comparator.comparing(License::getName))
                        .collect(Collectors.toList())
                )
                .dependencyLicenses(input.getDependencies().getDependency()
                        .stream()
                        .filter(d -> d.getLicenses() != null)
                        .filter(d -> d.getLicenses().getLicense() != null)
                        .map(d -> toDependency(d))
                        .sorted(Comparator.comparing(DependencyLicenses::getComponentId))
                        .collect(Collectors.toList())
                )
                .build();
    }

    private DependencyLicenses toDependency(DependencyType dependencyType) {
        return DependencyLicenses.builder()
                .componentId(ComponentId.builder()
                        .artifactID(dependencyType.getArtifactId())
                        .groupId(dependencyType.getGroupId())
                        .version(dependencyType.getVersion())
                        .build())
                .licenses(
                        (dependencyType.getLicenses() != null && dependencyType.getLicenses().getLicense() != null
                                ? dependencyType.getLicenses().getLicense().stream().map(l -> createLicense(l)).collect(Collectors.toSet())
                                : new HashSet<>())
                )
                .build();
    }

    private static License createLicense(LicenseType l) {
        String name = l.getName();
        String url = l.getUrl();
        switch (url) {
            case "https://www.apache.org/licenses/LICENSE-2.0.txt":
            case "http://www.apache.org/licenses/LICENSE-2.0.txt":
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt";
                name = "Apache License 2.0";
                break;

            case "http://www.eclipse.org/legal/epl-v10.html":
                url = "https://www.eclipse.org/legal/epl-v10.html";
                name = "Eclipse Public License - v1.0";
                break;

            case "https://www.eclipse.org/legal/epl-v20.html":
            case "http://www.eclipse.org/legal/epl-v20.html":
                url = "https://www.eclipse.org/legal/epl-v20.html";
                name = "Eclipse Public License - v2.0";
                break;
        }
        return License.builder().name(name).url(url).build();
    }
}
