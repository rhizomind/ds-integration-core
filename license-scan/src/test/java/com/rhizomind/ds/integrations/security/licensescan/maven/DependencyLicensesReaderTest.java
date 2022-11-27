package com.rhizomind.ds.integrations.security.licensescan.maven;

import com.rhizomind.ds.integrations.security.licensescan.DependencyLicensesSummary;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class DependencyLicensesReaderTest {

    @Test
    void shouldDeserializeXmlCorrectly() throws IOException, jakarta.xml.bind.JAXBException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            LicenseSummaryType value = new DependencyLicensesReader().readMavenDependencyLicenseReport(resourceAsStream);

            Assertions.assertEquals(87, value.getDependencies().getDependency().size());
        }
    }

    @Test
    void shouldContainsAllLicensesInUse() throws IOException, JAXBException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            DependencyLicensesSummary value = new DependencyLicensesReader().readSummary(resourceAsStream);

            Assertions.assertEquals(16, value.getLicenses().size());
        }
    }
    @Test
    void shouldContainsAllDependencies() throws IOException, JAXBException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            DependencyLicensesSummary value = new DependencyLicensesReader().readSummary(resourceAsStream);

            Assertions.assertEquals(87, value.getDependencyLicenses().size());
        }
    }
}
