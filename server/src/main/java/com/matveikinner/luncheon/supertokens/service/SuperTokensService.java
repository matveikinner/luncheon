package com.matveikinner.luncheon.supertokens.service;

import com.matveikinner.luncheon.supertokens.config.SuperTokensConfig;
import com.matveikinner.luncheon.supertokens.dto.CreateSessionRequestDto;
import com.matveikinner.luncheon.supertokens.dto.CreateSessionResponseDto;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignUpOrInRequestDto;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignUpOrInResponseDto;
import com.matveikinner.luncheon.supertokens.models.UserDataInDatabase;
import com.matveikinner.luncheon.supertokens.models.UserDataInJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuperTokensService {

    private final SuperTokensConfig superTokensConfig;


    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignup
//    public Mono<EmailPasswordSignUpOrInResponseDto> emailPasswordSignUp(String email, String password) {
//        EmailPasswordSignUpOrInRequestDto body = new EmailPasswordSignUpOrInRequestDto(
//                email, password
//        );
//
//        // TODO: Handle error(s) with ex. .doOnError(). Kill SuperTokens container to try out.
//        return this.superTokensConfig
//                .webClient()
//                .post()
//                .uri("/recipe/signup")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(body))
//                .retrieve()
//                .bodyToMono(EmailPasswordSignUpOrInResponseDto.class);
//    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignup
    public EmailPasswordSignUpOrInResponseDto emailPasswordSignUp(String email, String password) {
        HttpHeaders httpHeaders = this.superTokensConfig.superTokensHeaders();

        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = this.superTokensConfig.httpService();

        EmailPasswordSignUpOrInRequestDto body = new EmailPasswordSignUpOrInRequestDto(
                email, password
        );

        HttpEntity<EmailPasswordSignUpOrInRequestDto> entity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<EmailPasswordSignUpOrInResponseDto> response = restTemplate.exchange("/recipe/signup", HttpMethod.POST, entity, EmailPasswordSignUpOrInResponseDto.class);

        return response.getBody();
    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignin
//    public Mono<EmailPasswordSignUpOrInResponseDto> emailPasswordSignIn(String email, String password) {
//        EmailPasswordSignUpOrInRequestDto body = new EmailPasswordSignUpOrInRequestDto(
//                email, password
//        );
//
//        return this.superTokensConfig
//                .webClient()
//                .post()
//                .uri("/recipe/signin")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(body))
//                .retrieve()
//                .bodyToMono(EmailPasswordSignUpOrInResponseDto.class);
//    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/EmailPassword%20Recipe/emailPasswordSignin
    public EmailPasswordSignUpOrInResponseDto emailPasswordSignIn(String email, String password) {
        HttpHeaders httpHeaders = this.superTokensConfig.superTokensHeaders();

        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = this.superTokensConfig.httpService();

        EmailPasswordSignUpOrInRequestDto body = new EmailPasswordSignUpOrInRequestDto(
                email, password
        );

        HttpEntity<EmailPasswordSignUpOrInRequestDto> entity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<EmailPasswordSignUpOrInResponseDto> response = restTemplate.exchange("/recipe/signin", HttpMethod.POST, entity, EmailPasswordSignUpOrInResponseDto.class);

        return response.getBody();
    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/Session%20Recipe/createNewSession
//    public Mono<CreateSessionResponseDto<UserDataInJWT>> createSession(String userId) {
//        UserDataInJWT userDataInJWT = new UserDataInJWT("");
//        UserDataInDatabase userDataInDatabase = new UserDataInDatabase("");
//
//        CreateSessionRequestDto body = new CreateSessionRequestDto(userId, userDataInJWT, userDataInDatabase, false);
//
//        return this.superTokensConfig
//                .webClient()
//                .post()
//                .uri("/recipe/session")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(body))
//                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
//                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
//                .bodyToMono(new ParameterizedTypeReference<CreateSessionResponseDto<UserDataInJWT>>(){});
//    }

    // See https://app.swaggerhub.com/apis/supertokens/CDI/2.18.2#/Session%20Recipe/createNewSession
    public CreateSessionResponseDto<UserDataInJWT> createSession(String userId) {
        HttpHeaders httpHeaders = this.superTokensConfig.superTokensHeaders();

        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = this.superTokensConfig.httpService();

        UserDataInJWT userDataInJWT = new UserDataInJWT("");
        UserDataInDatabase userDataInDatabase = new UserDataInDatabase("");

        CreateSessionRequestDto body = new CreateSessionRequestDto(userId, userDataInJWT, userDataInDatabase, false);

        HttpEntity<CreateSessionRequestDto> entity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<CreateSessionResponseDto<UserDataInJWT>> response =
                restTemplate.exchange("/recipe/signin", HttpMethod.POST, entity, new ParameterizedTypeReference<CreateSessionResponseDto<UserDataInJWT>>() {
                });

        return response.getBody();
    }
}
