package com.rhizomind.ds.integrations.security.licensescan.maven;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class LicenseSummaryTypeReader {
    public static LicenseSummaryType getLicenseSummaryType(InputStream resourceAsStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return ((JAXBElement<LicenseSummaryType>) unmarshaller.unmarshal(
                        resourceAsStream
                )).getValue();
    }
}
