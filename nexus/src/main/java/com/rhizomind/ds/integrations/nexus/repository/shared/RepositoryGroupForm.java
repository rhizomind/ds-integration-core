package com.rhizomind.ds.integrations.nexus.repository.shared;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryGroupForm {

    @Singular
    private List<String> memberNames = new ArrayList<>();

}
