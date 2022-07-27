package com.rhizomind.ds.integrations.sonar.metric;

import lombok.Data;

import java.util.List;

@Data
public class MetricSearchResultRepresentation {

    private List<MetricRepresentation> metrics;

    private int total;
    private int p;
    private int ps;


}
