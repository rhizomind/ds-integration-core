package com.rhizomind.ds.integrations.nexus.blobstore;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileBlobStoreForm {

    private String path;
    private String name;

}
