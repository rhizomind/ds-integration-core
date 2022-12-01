package com.rhizomind.ds.integrations.security.licensescan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhizomind.ds.integrations.security.licensescan.hieronymus.Dependencies2LicenseReport;
import com.rhizomind.ds.integrations.security.licensescan.maven.DependencyType;
import com.rhizomind.ds.integrations.security.licensescan.maven.LicenseSummaryType;
import com.rhizomind.ds.integrations.security.licensescan.maven.LicenseType;
import com.rhizomind.ds.integrations.security.licensescan.maven.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class DependencyLicensesReader {

    private final JAXBContext context;
    private final ObjectMapper yamlReader;

    {
        try {
            context = JAXBContext.newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        yamlReader = new ObjectMapper();
    }

    public DependencyLicensesSummary readFromHieronymusReport(InputStream inputStream) throws IOException {
        return toSummary(yamlReader.readValue(inputStream, Dependencies2LicenseReport.class));
    }

    private DependencyLicensesSummary toSummary(Dependencies2LicenseReport input) {
        return DependencyLicensesSummary.builder()
                .licenses(
                        normalize(flattenLicenses(input.getDependencies(), o -> o.getLicenses()))
                )
                .dependencyLicenses(
                        input.getDependencies()
                                .stream()
                                .map(DependencyLicensesReader::toDependencyLicenses)
                                .collect(toList())
                )
                .build();
    }

    private static DependencyLicenses toDependencyLicenses(com.rhizomind.ds.integrations.security.licensescan.hieronymus.DependencyLicenses d) {
        return new DependencyLicenses(
                d.getName(),
                normalize(d.getLicenses()).stream().map(License::getName).collect(toSet())
        );
    }

    private static List<License> normalize(Collection<License> licenses) {
        return licenses
                .stream()
                .map(l -> normalizeLicense(l.getName(), l.getUrl()))
                .collect(toSet())
                .stream()
                .sorted(Comparator.comparing(License::getName))
                .collect(toList());
    }

    private static <T> List<License> flattenLicenses(List<T> dependencies, Function<T, ? extends Collection<License>> licenseExtractor) {
        return dependencies.stream()
                .filter(d -> licenseExtractor.apply(d) != null)
                .map(licenseExtractor)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private License toLicense(License license) {
        return null;
    }

    public DependencyLicensesSummary readFromMavenDependencyLicenseReport(InputStream inputStream) throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return toSummary(((JAXBElement<LicenseSummaryType>) unmarshaller.unmarshal(
                inputStream
        )).getValue());
    }

    private DependencyLicensesSummary toSummary(LicenseSummaryType input) {
        return DependencyLicensesSummary.builder()
                .licenses(input.getDependencies().getDependency()
                        .stream()
                        .filter(d -> d.getLicenses() != null)
                        .filter(d -> d.getLicenses().getLicense() != null)
                        .flatMap(d -> d.getLicenses().getLicense().stream())
                        .map(l -> toLicense(l))
                        .collect(toSet())
                        .stream()
                        .sorted(Comparator.comparing(License::getName))
                        .collect(toList())
                )
                .dependencyLicenses(input.getDependencies().getDependency()
                        .stream()
                        .filter(d -> d.getLicenses() != null)
                        .filter(d -> d.getLicenses().getLicense() != null)
                        .map(d -> toDependency(d))
                        .sorted(Comparator.comparing(DependencyLicenses::getComponentId))
                        .collect(toList())
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
                                ? dependencyType.getLicenses().getLicense().stream().map(l -> toLicense(l).getName()).collect(toSet())
                                : new HashSet<>())
                )
                .build();
    }

    private static License toLicense(LicenseType l) {
        return normalizeLicense(l.getName(), l.getUrl());
    }

    private static License normalizeLicense(String name, String url) {
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
