package com.matveikinner.luncheon.auth.service;

import com.matveikinner.luncheon.auth.entity.AuthProvider;
import com.matveikinner.luncheon.auth.entity.User;
import com.matveikinner.luncheon.auth.model.AuthProviderType;
import com.matveikinner.luncheon.auth.repository.UserRepository;
import com.matveikinner.luncheon.supertokens.dto.CreateSessionResponseDto;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignUpOrInResponseDto;
import com.matveikinner.luncheon.supertokens.models.UserDataInJWT;
import com.matveikinner.luncheon.supertokens.service.SuperTokensService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final SuperTokensService superTokensService;

    private final UserRepository userRepository;

    public EmailPasswordSignUpOrInResponseDto emailPasswordSignUp(String email, String password) {
        EmailPasswordSignUpOrInResponseDto response = this.superTokensService.emailPasswordSignUp(email, password);
        log.info("[AuthService] emailPasswordSignUp response: {}", response);

        response.user().ifPresent((value) -> {
            AuthProvider authProvider = new AuthProvider();

            authProvider.setProviderUserId(value.id());
            authProvider.setProvider(AuthProviderType.SUPERTOKENS);

            User user = new User();

            user.setEmail(value.email());
            user.getAuthProviders().add(authProvider);

            authProvider.setUser(user);

            this.userRepository.save(user);
        });

        return response;
    }

    public EmailPasswordSignUpOrInResponseDto emailPasswordSignIn(String email, String password) {
        EmailPasswordSignUpOrInResponseDto response = this.superTokensService.emailPasswordSignIn(email, password);
        log.info("[AuthService] emailPasswordSignIn response: {}", response);

        return response;
    }

    public CreateSessionResponseDto<UserDataInJWT> createSession(String userId) {
        CreateSessionResponseDto<UserDataInJWT> response = this.superTokensService.createSession(userId);
        log.info("[AuthService] createSession response: {}", response);

        return response;
    }
}
