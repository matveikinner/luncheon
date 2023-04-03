//package com.matveikinner.luncheon.auth.config;
//
//import com.matveikinner.luncheon.supertokens.dto.CreateSessionResponseDto;
//import com.matveikinner.luncheon.supertokens.models.UserDataInJWT;
//import com.matveikinner.luncheon.supertokens.service.SuperTokensService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//import java.util.ArrayList;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class SuperTokensAuthenticationProvider implements AuthenticationProvider {
//
//    private final SuperTokensService superTokensService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        var result = this.superTokensService.emailPasswordSignIn(username, password).block();
//
//        log.info("[SuperTokensAuthenticationProvider] result {}", result);
//
//        if (result.user().isPresent()) {
//            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
//        }
//
//        throw new BadCredentialsException("Incorrect user credentials");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
