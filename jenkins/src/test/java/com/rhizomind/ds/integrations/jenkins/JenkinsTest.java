package com.rhizomind.ds.integrations.jenkins;

import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;

class JenkinsTest {

    private static Jenkins jenkins;

    @BeforeAll
    public static void beforeALl() throws MalformedURLException {
         jenkins = new Jenkins(
                new URL("https://jenkins.solidify.pl/"),
                "tomasz.krzyzak",
                "",
                new RestEasyClientFactoryBuilder()
        );
    }

    @Test
    void createFolders() {
        MultivaluedMap folderForm = new MultivaluedHashMap();
        folderForm.add("name", "test-5");
        folderForm.add("mode", "com.cloudbees.hudson.plugins.folder.Folder");
        Response folder = jenkins.folders().createFolder(folderForm);

        MultivaluedMap subfolderForm = new MultivaluedHashMap();
        subfolderForm.add("name", "sub-test-5");
        subfolderForm.add("mode", "com.cloudbees.hudson.plugins.folder.Folder");
        Response subFolder = jenkins.folders().createSubFolder("job/test-5", subfolderForm);
    }
}