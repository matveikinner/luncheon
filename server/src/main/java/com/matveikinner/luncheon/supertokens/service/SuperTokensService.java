package com.matveikinner.luncheon.supertokens.service;

import com.matveikinner.luncheon.supertokens.config.SuperTokensConfig;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinRequestDto;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuperTokensService {

    private final SuperTokensConfig superTokensConfig;


    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignup
    public Mono<EmailPasswordSignupinResponseDto> emailPasswordSignup(String email, String password) {
        EmailPasswordSignupinRequestDto body = new EmailPasswordSignupinRequestDto(
                email, password
        );

        // TODO: Handle error(s) with ex. .doOnError(). Kill SuperTokens container to try out.
        return this.superTokensConfig
                .webClient()
                .post()
                .uri("/recipe/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(EmailPasswordSignupinResponseDto.class);
    }

}
