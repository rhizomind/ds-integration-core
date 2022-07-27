package com.rhizomind.ds.integrations.jira.server.serverinfo;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Locale;

@Data
public class ServerInfo {

    private String baseUrl;
    private String version;
    private int[] versionNumbers;
    private String buildNumber;
    private ZonedDateTime buildDate;
    private ZonedDateTime serverTime;
    private String scmInfo;
    private String serverTitle;

    /**
     * Cloud only
     */
    private LocaleRepresentation defaultLocale;

    /**
     * server only
     */
    private String buildPartnerName;
    /**
     * server only
     */
    private String deploymentType;

}
