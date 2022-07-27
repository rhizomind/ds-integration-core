package com.rhizomind.ds.integrations.sonar.measures;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ComponentMeasureDto {

    private String metric;
    private String value;

}
