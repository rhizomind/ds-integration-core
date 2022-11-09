package com.rhizomind.ds.integrations.nexus.roles;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleForm {

    private String id;
    private String name;
    private String description;
    @Singular
    private Set<String> privileges;
    private Set<String> roles;

}
