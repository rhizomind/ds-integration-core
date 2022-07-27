package com.rhizomind.ds.integrations.sonar.metric;

import lombok.Data;

@Data
public class MetricRepresentation {

    private String id;
    private String key;
    private String type;
    private String name;
    private String description;
    private String domain;
    private int direction;
    private boolean qualitative;
    private boolean hidden;
    private boolean custom;

}