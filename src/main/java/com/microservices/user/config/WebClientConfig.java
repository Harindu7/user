package com.microservices.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient companyServiceWebClient() {
        return WebClient.builder()
                .baseUrl("http://company-service:8081")
                .build();
    }
}
