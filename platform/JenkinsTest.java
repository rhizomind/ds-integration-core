package com.rhizomind.ds.integrations.jenkins;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhizomind.ds.integrations.jenkins.configfiles.ConfigFileForm;
import com.rhizomind.ds.integrations.jenkins.credentials.SSHPrivateKeySourceForm;
import com.rhizomind.ds.integrations.jenkins.credentials.SSHUsernameCredentialsForm;
import com.rhizomind.ds.integrations.jenkins.credentials.UsernamePasswordCredentialsForm;
import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;

class JenkinsTest {

    private static Jenkins jenkins;

    @BeforeAll
    public static void beforeALl() throws MalformedURLException {
         jenkins = new Jenkins(
                new URL("https://jenkins.solidify.pl/"),
                "tomasz.krzyzak",
                "11fb5b09c77d8150b6951f1a65f0ef6247",
                new RestEasyClientFactoryBuilder()
        );
    }

//    @Test
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

    @Test
    void configureAccounts() throws IOException {
        configSolidifyAccuratus("platform/accu/spaces/spreadium");
        configureSolidifyMcd("solidify-mcd");
        configureSolidifyPL("platform/rzm/spaces/certus");

    }

    private void configureSolidifyMcd(String accountName) throws IOException {
        createUsernamePasswordCredentials(accountName, "docker-registry-credentials", "svcjenkins", "svcjenkins", true, "DockerRegistryCredentials used in pipelines");
        createUsernamePasswordCredentials(accountName, "sonar_default-credentials", "squ_39b0379c11f021a3a71fa6f2e2fbd34b3f5e5cf2", "", true, "Sonar Credentials used to upload analyses");
        createUsernamePasswordCredentials(accountName,"bitbucketcloud-usernametoken", "tomasz-krzyzak", "mnAXKsWjFeywTvGcqTJr", true, "Credentials used to scan BBCloud for repositories");
        createSshUsernameCredentials(
                accountName,
                "accuratus-user-svcjenkins-bitbucketcloud-key",
                "svcjenkins",
                readAsString("/"+accountName+"/jenkins/user-svcjenkins-bitbucketcloud-key"),
                true,
                "SSH key for Jenkins user to pull repos from git server 2"
        );

        createConfigFile(
                accountName,
                "default-maven-settings-xml",
                "accuratus default maven settings",
                "Maven settings.xml for Accuratus client",
                readAsString("/"+accountName+"/jenkins/default-maven-settings.xml")
        );
        createConfigFile(
                accountName,
                "envs",
                accountName + " environment variables",
                "File containing non-sensitive environment variables used by the pipeline",
                readAsString("/"+accountName+"/jenkins/envs.properties")
        );
        createConfigFile(
                accountName,
                "client-config",
                accountName + " client config",
                "File containing client-config",
                readAsString("/"+accountName+"/jenkins/jenkins-org-config.json")
        );
    }

    private void configSolidifyAccuratus(String accountName) throws IOException {
        createUsernamePasswordCredentials(accountName, "docker-registry-credentials", "svcjenkins", "svcjenkins", true, "random description");
        createUsernamePasswordCredentials(accountName, "sonar_default-credentials", "squ_39b0379c11f021a3a71fa6f2e2fbd34b3f5e5cf2", "", true, "random description");
        createUsernamePasswordCredentials(accountName,"bitbucketcloud-usernametoken", "tomasz-krzyzak", "mnAXKsWjFeywTvGcqTJr", true, "random description");
        createSshUsernameCredentials(accountName, "accuratus-user-svcjenkins-bitbucketcloud-key", "svcjenkins", readAsString("/platform/accu/spaces/spreadium/setup/jenkins/user-svcjenkins-bitbucketcloud-key"), true, "SSH key for Jenkins user to pull repos from git server");
        createConfigFile(
                accountName,
                "default-maven-settings-xml",
                "accuratus default maven settings",
                "Maven settings.xml for Accuratus client",
                readAsString("/platform/accu/spaces/spreadium/setup/jenkins/default-maven-settings.xml")
        );
        createConfigFile(
                accountName,
                "dt-accu-prod2",
                "dt-accu-prod2",
                "k8s config file for prod2 cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/accu/spaces/spreadium/targets/prod2/kubeconfig-dt-accu-prod2")
        );
        createConfigFile(
                accountName,
                "dt-accu-sit",
                "dt-accu-sit",
                "k8s config file for sit cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/accu/spaces/spreadium/targets/kubekonfig-dt-accu-sit")
        );
        createConfigFile(
                accountName,
                "dt-accu-uat",
                "dt-accu-uat",
                "k8s config file for uat cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/accu/spaces/spreadium/targets/uat/kubeconfig-dt-accu-uat")
        );
        createConfigFile(
                accountName,
                "dt-accu-staging",
                "dt-accu-staging",
                "k8s config file for staging cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/accu/spaces/spreadium/targets/staging/kubeconfig-dt-accu-staging")
        );
        createConfigFile(
                accountName,
                "envs",
                accountName + " environment variables",
                "File containing non-sensitive environment variables used by the pipeline",
                readAsString("/platform/accu/spaces/spreadium/setup/jenkins/envs.properties")
        );
        createConfigFile(
                accountName,
                "client-config",
                accountName + " client config",
                "File containing client-config",
                readAsString("/platform/accu/spaces/spreadium/setup/jenkins/jenkins-space-config.json")
        );
    }

    private void configureSolidifyPL(String accountName) throws IOException {
        createUsernamePasswordCredentials(accountName, "docker-registry-credentials", "svcjenkins", "svcjenkins", true, "random description");
        createUsernamePasswordCredentials(accountName, "sonar_default-credentials", "squ_22fadf227e91092cf8d3e939f906c4c5cebce488", "", true, "random description");
        createUsernamePasswordCredentials(accountName,"bitbucketcloud-usernametoken", "tomasz-krzyzak", "mnAXKsWjFeywTvGcqTJr", true, "random description");
        createSshUsernameCredentials(accountName, "solidify-user-svcjenkins-bitbucketcloud-key", "svcjenkins", readAsString("/platform/rzm/spaces/certus/setup/jenkins/user-svcjenkins-bitbucketcloud-key"), true, "SSH key for Jenkins user to pull repos from git server");

        createConfigFile(
                accountName,
                "default-maven-settings-xml",
                "rhizomind default maven settings",
                "Maven settings.xml for Rhizomind client",
                readAsString("/platform/rzm/spaces/certus/setup/jenkins/default-maven-settings.xml")
        );
        createConfigFile(
                accountName,
                "dt-rzm-sit",
                "dt-rzm-sit",
                "k8s config file for sit cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/rzm/spaces/certus/spaces/certus/dts/dt-rzm-sit")
        );
        createConfigFile(
                accountName,
                "dt-rzm-uat",
                "dt-rzm-uat",
                "k8s config file for uat cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/rzm/spaces/certus/spaces/certus/dts/dt-rzm-uat")
        );
        createConfigFile(
                accountName,
                "dt-rzm-prod",
                "dt-rzm-prod",
                "k8s config file for uat cluster (Temp solution - will be removed ASAP)",
                readAsString("/platform/rzm/spaces/certus/spaces/certus/dts/dt-rzm-prod")
        );
        createConfigFile(
                accountName,
                "envs",
                accountName + " environment variables",
                "File containing non-sensitive environment variables used by the pipeline",
                readAsString("/platform/rzm/spaces/certus/setup/jenkins/envs.properties")
        );
        createConfigFile(
                accountName,
                "client-config",
                accountName + " client config",
                "File containing client-config",
                readAsString("/platform/rzm/spaces/certus/setup/jenkins/jenkins-org-config.json")
        );
    }

    private void createGlobalSshUsernameCredentials(String id, String username, String privateKey, boolean usernameSecret, String description) throws JsonProcessingException {
        MultivaluedMap credentialsForm = new MultivaluedHashMap();
        HashMap<Object, Object> v = new HashMap<>();
        v.put("credentials", new SSHUsernameCredentialsForm(
                id,
                username,
                usernameSecret,
                description,
                new SSHPrivateKeySourceForm(privateKey)
        ));
        credentialsForm.putSingle("json", new ObjectMapper().writeValueAsString(v));
        Response response = jenkins.credentials().modifyCredentials(credentialsForm);

    }

    private String readAsString(String relativefilePath) throws IOException {
        return new String(Files.readAllBytes(new File(getClass().getResource(relativefilePath).getFile()).toPath()));
    }

    private void createUsernamePasswordCredentials(String accountName, String id, String username, String password, boolean secretUsername, String description) throws JsonProcessingException {
        MultivaluedMap credentialsForm = new MultivaluedHashMap();
        HashMap<Object, Object> v = new HashMap<>();
        v.put("credentials", new UsernamePasswordCredentialsForm(
                id,
                username,
                password,
                secretUsername,
                description
        ));
        credentialsForm.putSingle("json", new ObjectMapper().writeValueAsString(v));
        Response response = jenkins.credentials().modifyCredentials("job/" + accountName, credentialsForm);
    }

    private void createSshUsernameCredentials(String accountName, String id, String username, String privateKey, boolean usernameSecret, String description) throws JsonProcessingException {
        MultivaluedMap credentialsForm = new MultivaluedHashMap();
        HashMap<Object, Object> v = new HashMap<>();
        v.put("credentials", new SSHUsernameCredentialsForm(
                id,
                username,
                usernameSecret,
                description,
                new SSHPrivateKeySourceForm(privateKey)
        ));
        credentialsForm.putSingle("json", new ObjectMapper().writeValueAsString(v));
        Response response = jenkins.credentials().modifyCredentials("job/" + accountName, credentialsForm);

        Response.StatusType statusInfo = response.getStatusInfo();
        System.out.print(accountName+" - credentials - "+id+": ");
        if (statusInfo.getFamily() != Family.SUCCESSFUL && statusInfo.getFamily()!= Family.REDIRECTION ) {
            System.out.println("ERR: ("+response.getStatus()+") "+response.readEntity(String.class));
        } else {
            System.out.println("OK");
        }
    }

    private static void createConfigFile(String accountName, String id, String fileName, String comment, String content) throws JsonProcessingException {
        MultivaluedMap configFileForm = new MultivaluedHashMap();
        configFileForm.putSingle("json", new ObjectMapper().writeValueAsString(new ConfigFileForm(
                id,
                fileName,
                comment,
                content
        )));
        Response response = jenkins.configFiles().modifyConfigFile("job/" + accountName, configFileForm);

        Response.StatusType statusInfo = response.getStatusInfo();
        System.out.print(accountName+" - config file - "+id+": ");
        if (statusInfo.getFamily() != Family.SUCCESSFUL && statusInfo.getFamily()!= Family.REDIRECTION ) {
            System.out.println("ERR: ("+response.getStatus()+") "+response.readEntity(String.class));
        } else {
            System.out.println("OK");
        }

    }
}