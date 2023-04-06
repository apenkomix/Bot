package config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
@ComponentScan("service")
public class BotConfig {
    @Value("${telegram.service.username}")
    String botName;
    @Value("${telegram.service.token}")
    String token;
}
