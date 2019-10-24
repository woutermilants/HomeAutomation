package be.milants.homeautomation.config;

import org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTags;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
