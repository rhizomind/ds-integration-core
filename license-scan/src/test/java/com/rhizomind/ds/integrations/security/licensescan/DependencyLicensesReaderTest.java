package com.rhizomind.ds.integrations.security.licensescan;

import com.rhizomind.ds.integrations.security.licensescan.DependencyLicensesReader;
import com.rhizomind.ds.integrations.security.licensescan.DependencyLicensesSummary;
import com.rhizomind.ds.integrations.security.licensescan.maven.LicenseSummaryType;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class DependencyLicensesReaderTest {

    @Test
    void shouldContainsAllLicensesInUse() throws IOException, JAXBException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            DependencyLicensesSummary value = new DependencyLicensesReader().readFromMavenDependencyLicenseReport(resourceAsStream);

            Assertions.assertEquals(16, value.getLicenses().size());
        }
    }
    @Test
    void shouldContainsAllDependencies() throws IOException, JAXBException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            DependencyLicensesSummary value = new DependencyLicensesReader().readFromMavenDependencyLicenseReport(resourceAsStream);

            Assertions.assertEquals(87, value.getDependencyLicenses().size());
        }
    }
}
