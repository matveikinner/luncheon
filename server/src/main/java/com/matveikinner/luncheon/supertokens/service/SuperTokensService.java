package com.matveikinner.luncheon.supertokens.service;

import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SuperTokensService {

    @Autowired
    private final Environment env;

    private final WebClient webClient;

    public SuperTokensService(Environment env, WebClient.Builder webClientBuilder) {
        this.env = env;
        this.webClient = webClientBuilder
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("cdi-version", this.env.getProperty("variables.supertokens.version"));
                    httpHeaders.add("api-key", this.env.getProperty("variables.supertokens.apiKey"));
                })
                .baseUrl("http://localhost:3567")
                .build();
    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignup
    public Mono<EmailPasswordSignupinResponseDto> emailPasswordSignup(String email, String password) {
        EmailPasswordSignupinRequestDto body = new EmailPasswordSignupinRequestDto(
                email, password
        );

        return this.webClient
                .post()
                .uri("/recipe/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(EmailPasswordSignupinResponseDto.class);
    }

}
