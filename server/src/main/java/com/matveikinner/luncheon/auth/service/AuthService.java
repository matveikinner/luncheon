package com.matveikinner.luncheon.auth.service;

import com.matveikinner.luncheon.auth.entity.AuthProvider;
import com.matveikinner.luncheon.auth.entity.User;
import com.matveikinner.luncheon.auth.model.AuthProviderType;
import com.matveikinner.luncheon.auth.repository.UserRepository;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import com.matveikinner.luncheon.supertokens.service.SuperTokensService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final SuperTokensService superTokensService;

    private final UserRepository userRepository;

    public Mono<EmailPasswordSignupinResponseDto> emailPasswordSignup(String email, String password) {
        return this.superTokensService.emailPasswordSignup(email, password).doOnSuccess(result -> {
            // SuperTokens returns on email conflicts HTTP status 200, and body with single property "status" which has
            // description of the error. Therefore, if user is missing, there was an error. Otherwise, all good.
            result.user().ifPresent((value) -> {
                AuthProvider authProvider = new AuthProvider();

                authProvider.setProviderUserId(value.id());
                authProvider.setProvider(AuthProviderType.SUPERTOKENS);

                User user = new User();

                user.setEmail(value.email());
                user.getAuthProviders().add(authProvider);

                authProvider.setUser(user);

                this.userRepository.save(user);
            });
        });
    }
}
