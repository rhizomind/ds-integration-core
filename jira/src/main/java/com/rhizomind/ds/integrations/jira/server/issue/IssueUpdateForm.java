package com.rhizomind.ds.integrations.jira.server.issue;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class IssueUpdateForm {

    private Map<String, Object> fields;
    private Map<String, List<IssueUpdateOperationForm>> update;

}
