package com.rhizomind.ds.integrations.sonar;

import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import com.rhizomind.ds.integrations.sonar.metric.MetricSearchResultRepresentation;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

class SonarServerTest {

    @Test
    void name() throws MalformedURLException {
        SonarServer sonarServer = new SonarServer(
                new URL("https://sonar.accu.account.solidify.pl/"),
                "xxx",
                new RestEasyClientFactoryBuilder()
        );

        String ping = sonarServer.system().ping();
//        SystemHealthRepresentation health = sonarServer.system().health();
//        SystemInfoRepresentation info = sonarServer.system().info();
        MetricSearchResultRepresentation search = sonarServer.metricsResource().search(1, 500);
    }

}
