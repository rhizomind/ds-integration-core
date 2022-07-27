package com.rhizomind.ds.integrations.sonar.measures;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Period {

    private int index;
    private String mode;
    private ZonedDateTime date;

}