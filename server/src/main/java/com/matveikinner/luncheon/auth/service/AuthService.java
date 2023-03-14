package com.matveikinner.luncheon.auth.service;

import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import com.matveikinner.luncheon.supertokens.service.SuperTokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SuperTokensService superTokensService;

    public Mono<EmailPasswordSignupinResponseDto> emailPasswordSignup(String email, String password) {
        return this.superTokensService.emailPasswordSignup(email, password);
    }
}
