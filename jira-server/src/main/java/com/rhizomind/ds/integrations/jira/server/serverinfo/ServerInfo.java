package com.rhizomind.ds.integrations.jira.server.serverinfo;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ServerInfo {

    private String baseUrl;
    private String version;
    private int[] versionNumbers;
    private String buildNumber;
    private ZonedDateTime buildDate;
    private ZonedDateTime serverTime;
    private String scmInfo;
    private String buildPartnerName;
    private String serverTitle;
    private String deploymentType;

}
