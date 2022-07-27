package com.rhizomind.ds.integrations.sonar.measures;

import lombok.Data;

import java.util.List;

@Data
public class ComponentMeasuresDto {

    private String id;
    private String key;
    private String name;
    private String description;
    private String qualifier;
    private List<ComponentMeasureDto> measures;

}
