package com.microservices.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${services.company-service.url}")
    private String companyServiceUrl;

    @Bean
    public WebClient companyServiceWebClient() {
        return WebClient.builder()
                .baseUrl(companyServiceUrl)
                .build();
    }
}
