package com.rhizomind.ds.integrations.jenkins;

import com.rhizomind.ds.integrations.jenkins.system.SystemInfo;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class JenkinsTest {

    @Test
    void name() throws MalformedURLException {
        Jenkins jenkins = new Jenkins(
                new URL("https://jenkins.solidify.pl/"),
                "tomasz.krzyzak",
                "11b3ce79e1ab7d201a8b43161c780f256d",
                new RestEasyClientFactoryBuilder()
        );

        SystemInfo read = SystemInfo.read(jenkins.system().systemInfo());

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