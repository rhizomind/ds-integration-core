//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.15 at 10:29:00 PM CEST 
//


package com.rhizomind.ds.integrations.maven.settings.v120;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the file specification used to activate a profile. The missing value will be a the
 *                 location of a file that needs to exist, and if it doesn't the profile must run. On the other hand exists will test for the existence
 *                 of the file and if it is there will run the profile.
 *             
 * 
 * <p>Java class for ActivationFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivationFile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="missing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="exists" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivationFile", propOrder = {

})
public class ActivationFile {

    protected String missing;
    protected String exists;

    /**
     * Gets the value of the missing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissing() {
        return missing;
    }

    /**
     * Sets the value of the missing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissing(String value) {
        this.missing = value;
    }

    /**
     * Gets the value of the exists property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExists() {
        return exists;
    }

    /**
     * Sets the value of the exists property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExists(String value) {
        this.exists = value;
    }

}
