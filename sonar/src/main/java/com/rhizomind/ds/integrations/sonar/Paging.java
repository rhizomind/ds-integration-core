package com.rhizomind.ds.integrations.sonar;

import lombok.Data;

@Data
public class Paging {

    private int total;
    private int pageIndex;
    private int pageSize;

}
