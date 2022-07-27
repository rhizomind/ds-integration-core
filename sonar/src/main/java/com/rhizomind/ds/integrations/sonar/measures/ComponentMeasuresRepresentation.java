package com.rhizomind.ds.integrations.sonar.measures;

import lombok.Data;

import java.util.List;

@Data
public class ComponentMeasuresRepresentation {

    private ComponentMeasuresDto component;
    private List<Period> periods;
}
