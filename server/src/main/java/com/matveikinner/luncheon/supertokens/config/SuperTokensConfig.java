package com.matveikinner.luncheon.supertokens.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class SuperTokensConfig {
    @Value("${supertokens.url}")
    private String url;

    @Value("${supertokens.version}")
    private String version;

    @Value("${supertokens.apiKey}")
    private String apiKey;

    private final RestTemplateBuilder restTemplateBuilder;

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

    @Bean
    public RestTemplate httpService() {
        return restTemplateBuilder.rootUri(this.url).build();
    }

    public HttpHeaders superTokensHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("cdi-version", this.version);
        httpHeaders.add("api-key", this.apiKey);

        return httpHeaders;
    }
}
