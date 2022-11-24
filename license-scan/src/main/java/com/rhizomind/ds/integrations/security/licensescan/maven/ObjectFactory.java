
package com.rhizomind.ds.integrations.security.licensescan.maven;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rhizomind.ds.integrations.security.licensescan.maven package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LicenseSummary_QNAME = new QName("", "licenseSummary");
    private final static QName _LicensesTypeLicense_QNAME = new QName("", "license");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rhizomind.ds.integrations.security.licensescan.maven
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LicenseSummaryType }
     * 
     */
    public LicenseSummaryType createLicenseSummaryType() {
        return new LicenseSummaryType();
    }

    /**
     * Create an instance of {@link LicenseType }
     * 
     */
    public LicenseType createLicenseType() {
        return new LicenseType();
    }

    /**
     * Create an instance of {@link DependencyType }
     * 
     */
    public DependencyType createDependencyType() {
        return new DependencyType();
    }

    /**
     * Create an instance of {@link LicensesType }
     * 
     */
    public LicensesType createLicensesType() {
        return new LicensesType();
    }

    /**
     * Create an instance of {@link DependenciesType }
     * 
     */
    public DependenciesType createDependenciesType() {
        return new DependenciesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenseSummaryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "licenseSummary")
    public JAXBElement<LicenseSummaryType> createLicenseSummary(LicenseSummaryType value) {
        return new JAXBElement<LicenseSummaryType>(_LicenseSummary_QNAME, LicenseSummaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "license", scope = LicensesType.class)
    public JAXBElement<LicenseType> createLicensesTypeLicense(LicenseType value) {
        return new JAXBElement<LicenseType>(_LicensesTypeLicense_QNAME, LicenseType.class, LicensesType.class, value);
    }

}
