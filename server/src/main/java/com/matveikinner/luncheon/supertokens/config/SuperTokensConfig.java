package com.matveikinner.luncheon.supertokens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SuperTokensConfig {
    @Value("${supertokens.url}")
    private String url;

    @Value("${supertokens.version}")
    private String version;

    @Value("${supertokens.apiKey}")
    private String apiKey;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("cdi-version", this.version);
                    httpHeaders.add("api-key", this.apiKey);
                })
                .baseUrl(this.url)
                .build();
    }
}
