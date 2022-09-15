//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.15 at 10:29:00 PM CEST 
//


package com.rhizomind.ds.integrations.maven.settings.v120;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rhizomind.ds.integrations.maven.settings.v120 package. 
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

    private final static QName _Settings_QNAME = new QName("http://maven.apache.org/SETTINGS/1.2.0", "settings");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rhizomind.ds.integrations.maven.settings.v120
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Profile }
     * 
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link Server }
     * 
     */
    public Server createServer() {
        return new Server();
    }

    /**
     * Create an instance of {@link Settings }
     * 
     */
    public Settings createSettings() {
        return new Settings();
    }

    /**
     * Create an instance of {@link Proxy }
     * 
     */
    public Proxy createProxy() {
        return new Proxy();
    }

    /**
     * Create an instance of {@link Mirror }
     * 
     */
    public Mirror createMirror() {
        return new Mirror();
    }

    /**
     * Create an instance of {@link Repository }
     * 
     */
    public Repository createRepository() {
        return new Repository();
    }

    /**
     * Create an instance of {@link RepositoryPolicy }
     * 
     */
    public RepositoryPolicy createRepositoryPolicy() {
        return new RepositoryPolicy();
    }

    /**
     * Create an instance of {@link Activation }
     * 
     */
    public Activation createActivation() {
        return new Activation();
    }

    /**
     * Create an instance of {@link ActivationOS }
     * 
     */
    public ActivationOS createActivationOS() {
        return new ActivationOS();
    }

    /**
     * Create an instance of {@link ActivationProperty }
     * 
     */
    public ActivationProperty createActivationProperty() {
        return new ActivationProperty();
    }

    /**
     * Create an instance of {@link ActivationFile }
     * 
     */
    public ActivationFile createActivationFile() {
        return new ActivationFile();
    }

    /**
     * Create an instance of {@link Profile.Properties }
     * 
     */
    public Profile.Properties createProfileProperties() {
        return new Profile.Properties();
    }

    /**
     * Create an instance of {@link Profile.Repositories }
     * 
     */
    public Profile.Repositories createProfileRepositories() {
        return new Profile.Repositories();
    }

    /**
     * Create an instance of {@link Profile.PluginRepositories }
     * 
     */
    public Profile.PluginRepositories createProfilePluginRepositories() {
        return new Profile.PluginRepositories();
    }

    /**
     * Create an instance of {@link Server.Configuration }
     * 
     */
    public Server.Configuration createServerConfiguration() {
        return new Server.Configuration();
    }

    /**
     * Create an instance of {@link Settings.Proxies }
     * 
     */
    public Settings.Proxies createSettingsProxies() {
        return new Settings.Proxies();
    }

    /**
     * Create an instance of {@link Settings.Servers }
     * 
     */
    public Settings.Servers createSettingsServers() {
        return new Settings.Servers();
    }

    /**
     * Create an instance of {@link Settings.Mirrors }
     * 
     */
    public Settings.Mirrors createSettingsMirrors() {
        return new Settings.Mirrors();
    }

    /**
     * Create an instance of {@link Settings.Profiles }
     * 
     */
    public Settings.Profiles createSettingsProfiles() {
        return new Settings.Profiles();
    }

    /**
     * Create an instance of {@link Settings.ActiveProfiles }
     * 
     */
    public Settings.ActiveProfiles createSettingsActiveProfiles() {
        return new Settings.ActiveProfiles();
    }

    /**
     * Create an instance of {@link Settings.PluginGroups }
     * 
     */
    public Settings.PluginGroups createSettingsPluginGroups() {
        return new Settings.PluginGroups();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Settings }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Settings }{@code >}
     */
    @XmlElementDecl(namespace = "http://maven.apache.org/SETTINGS/1.2.0", name = "settings")
    public JAXBElement<Settings> createSettings(Settings value) {
        return new JAXBElement<Settings>(_Settings_QNAME, Settings.class, null, value);
    }

}
