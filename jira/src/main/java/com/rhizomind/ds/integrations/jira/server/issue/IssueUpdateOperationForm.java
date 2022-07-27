package com.rhizomind.ds.integrations.jira.server.issue;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class IssueUpdateOperationForm {

    private String set;
    private String add;
    private String remove;
    private Map<String, String> edit;

}
