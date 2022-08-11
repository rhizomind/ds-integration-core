//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.08.11 at 08:23:43 PM CEST 
//


package com.rhizomind.ds.integrations.owasp;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;


/**
 * <p>Java class for cvssV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cvssV3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="baseScore" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="attackVector" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="attackComplexity" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="privilegesRequired" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userInteraction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scope" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="confidentialityImpact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="integrityImpact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="availabilityImpact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="baseSeverity" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="exploitabilityScore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="impactScore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cvssV3", propOrder = {
    "baseScore",
    "attackVector",
    "attackComplexity",
    "privilegesRequired",
    "userInteraction",
    "scope",
    "confidentialityImpact",
    "integrityImpact",
    "availabilityImpact",
    "baseSeverity",
    "exploitabilityScore",
    "impactScore",
    "version"
})
public class CvssV3 {

    @XmlElement(required = true)
    protected BigDecimal baseScore;
    @XmlElement(required = true)
    protected String attackVector;
    @XmlElement(required = true)
    protected String attackComplexity;
    @XmlElement(required = true)
    protected String privilegesRequired;
    @XmlElement(required = true)
    protected String userInteraction;
    @XmlElement(required = true)
    protected String scope;
    @XmlElement(required = true)
    protected String confidentialityImpact;
    @XmlElement(required = true)
    protected String integrityImpact;
    @XmlElement(required = true)
    protected String availabilityImpact;
    @XmlElement(required = true)
    protected String baseSeverity;
    protected BigDecimal exploitabilityScore;
    protected BigDecimal impactScore;
    protected BigDecimal version;

    /**
     * Gets the value of the baseScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseScore() {
        return baseScore;
    }

    /**
     * Sets the value of the baseScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseScore(BigDecimal value) {
        this.baseScore = value;
    }

    /**
     * Gets the value of the attackVector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttackVector() {
        return attackVector;
    }

    /**
     * Sets the value of the attackVector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttackVector(String value) {
        this.attackVector = value;
    }

    /**
     * Gets the value of the attackComplexity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttackComplexity() {
        return attackComplexity;
    }

    /**
     * Sets the value of the attackComplexity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttackComplexity(String value) {
        this.attackComplexity = value;
    }

    /**
     * Gets the value of the privilegesRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivilegesRequired() {
        return privilegesRequired;
    }

    /**
     * Sets the value of the privilegesRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivilegesRequired(String value) {
        this.privilegesRequired = value;
    }

    /**
     * Gets the value of the userInteraction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserInteraction() {
        return userInteraction;
    }

    /**
     * Sets the value of the userInteraction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserInteraction(String value) {
        this.userInteraction = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the confidentialityImpact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfidentialityImpact() {
        return confidentialityImpact;
    }

    /**
     * Sets the value of the confidentialityImpact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfidentialityImpact(String value) {
        this.confidentialityImpact = value;
    }

    /**
     * Gets the value of the integrityImpact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegrityImpact() {
        return integrityImpact;
    }

    /**
     * Sets the value of the integrityImpact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegrityImpact(String value) {
        this.integrityImpact = value;
    }

    /**
     * Gets the value of the availabilityImpact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailabilityImpact() {
        return availabilityImpact;
    }

    /**
     * Sets the value of the availabilityImpact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailabilityImpact(String value) {
        this.availabilityImpact = value;
    }

    /**
     * Gets the value of the baseSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseSeverity() {
        return baseSeverity;
    }

    /**
     * Sets the value of the baseSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseSeverity(String value) {
        this.baseSeverity = value;
    }

    /**
     * Gets the value of the exploitabilityScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExploitabilityScore() {
        return exploitabilityScore;
    }

    /**
     * Sets the value of the exploitabilityScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExploitabilityScore(BigDecimal value) {
        this.exploitabilityScore = value;
    }

    /**
     * Gets the value of the impactScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpactScore() {
        return impactScore;
    }

    /**
     * Sets the value of the impactScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpactScore(BigDecimal value) {
        this.impactScore = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

}
