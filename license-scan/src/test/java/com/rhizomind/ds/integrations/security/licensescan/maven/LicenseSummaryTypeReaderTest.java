package com.rhizomind.ds.integrations.security.licensescan.maven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

class LicenseSummaryTypeReaderTest {

    @Test
    void name() throws JAXBException, IOException {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/licenses.xml")) {
            LicenseSummaryType value = LicenseSummaryTypeReader.getLicenseSummaryType(resourceAsStream);

            Assertions.assertEquals(87, value.getDependencies().getDependency().size());
        }
    }

}
