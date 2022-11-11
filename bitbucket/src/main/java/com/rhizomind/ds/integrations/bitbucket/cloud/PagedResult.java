package com.rhizomind.ds.integrations.bitbucket.cloud;

import lombok.Data;

import java.util.List;

@Data
public class PagedResult<T> {

    private int size;
    private int page;
    private int pagelen;

    private List<T> values;

    private String next;
    private String previous;
}
