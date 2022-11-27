package com.rhizomind.ds.integrations.owasp;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DependencyVulnerabilitiesReaderTest {

    @ParameterizedTest(name = "reading xml - {argumentsWithNames}")
    @ValueSource(strings = {
            "/dependency-check-report-1-2.5-7.3.2.xml",
            "/dependency-check-report-2-2.5-7.3.2.xml",
            "/dependency-check-report-2-2.5-6.5.3.xml"
    }
    )
    void shouldReadXmlCorrectly(String filename) throws jakarta.xml.bind.JAXBException {
        new DependencyVulnerabilitiesReader().readMavenDependencyVulnerabilitiesReport(getClass().getResourceAsStream(filename));
    }

    @Test
    void summaryReportShouldHaveComponentInformation() throws JAXBException {
        DependencyVulnerabilitiesReader dependencyVulnerabilitiesReader = new DependencyVulnerabilitiesReader();
        DependencyVulnerabilitiesSummary result = dependencyVulnerabilitiesReader.readSummary(getClass().getResourceAsStream("/dependency-check-report-2-2.5-7.3.2.xml"));

        ComponentId componentId = result.getComponentId();
        assertEquals("bitbucket-client", componentId.getArtifactId());
        assertEquals("com.rhizomind.ds.integrations", componentId.getGroupId());
        assertEquals("0.1-SNAPSHOT", componentId.getVersion());
        assertEquals(ZonedDateTime.parse("2022-11-25T22:16:47.074Z"), result.getReportDate());
    }

    @Test
    void summaryReportShouldHaveVulnerabilitiesList() throws JAXBException {
        DependencyVulnerabilitiesReader dependencyVulnerabilitiesReader = new DependencyVulnerabilitiesReader();
        DependencyVulnerabilitiesSummary result = dependencyVulnerabilitiesReader.readSummary(getClass().getResourceAsStream("/dependency-check-report-2-2.5-7.3.2.xml"));

        assertEquals(1, result.getVulnerableDependencies().size());

        VulnerableDependency vulnerableDependency = result.getVulnerableDependencies().get(0);
        assertEquals(VulnerabilitySeverity.HIGH, vulnerableDependency.getHighestSeverity());
    }
}
