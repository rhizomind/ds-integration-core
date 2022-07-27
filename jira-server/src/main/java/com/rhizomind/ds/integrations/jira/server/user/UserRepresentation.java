package com.rhizomind.ds.integrations.jira.server.user;

import lombok.Data;

import java.net.URL;
import java.util.Map;

@Data
public class UserRepresentation {

    private String key;
    private String name;
    private String displayName;
    private URL self;
    private boolean active;
    private Map<String, String> avatarUrls;
    private String timeZone;

}
