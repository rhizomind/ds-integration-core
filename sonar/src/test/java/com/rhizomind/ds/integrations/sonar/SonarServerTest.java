package com.rhizomind.ds.integrations.sonar;

import com.rhizomind.ds.integrations.resteasy.RestEasyClientFactoryBuilder;
import com.rhizomind.ds.integrations.sonar.metric.MetricSearchResultRepresentation;
import org.junit.jupiter.api.Test;

class SonarServerTest {

    @Test
    void name() {
        SonarServer sonarServer = new SonarServer(
                "https://sonar.accu.account.solidify.pl/",
                "squ_fe1f28937824782e98034e7139ea6e04ecd2784f",
                new RestEasyClientFactoryBuilder()
        );

        String ping = sonarServer.system().ping();
//        SystemHealthRepresentation health = sonarServer.system().health();
//        SystemInfoRepresentation info = sonarServer.system().info();
        MetricSearchResultRepresentation search = sonarServer.metricsResource().search(1, 500);
    }

}