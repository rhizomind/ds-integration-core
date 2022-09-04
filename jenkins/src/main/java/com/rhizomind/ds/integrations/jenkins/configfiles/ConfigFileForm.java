package com.rhizomind.ds.integrations.jenkins.configfiles;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class ConfigFileForm {

    private Map<String, String> config = new HashMap<>();

    public ConfigFileForm(String id, String name, String comment, String content) {
        config.put("stapler-class", "org.jenkinsci.plugins.configfiles.custom.CustomConfig");
        config.put("id", id);
        config.put("providerId", "org.jenkinsci.plugins.configfiles.custom.CustomConfig");
        config.put("name", name);
        config.put("comment", comment);
        config.put("content", content);
    }
}
