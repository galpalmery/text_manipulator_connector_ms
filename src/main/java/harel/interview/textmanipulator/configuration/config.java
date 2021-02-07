package harel.interview.textmanipulator.configuration;

import harel.interview.textmanipulator.services.ConnectorApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    ConnectorApplicationService connectorApplicationService() {
        return new ConnectorApplicationService();
    }

}
