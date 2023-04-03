package com.matveikinner.luncheon.auth.controller;

import com.matveikinner.luncheon.auth.dto.EmailPasswordDto;
import com.matveikinner.luncheon.auth.service.AuthService;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignUpOrInResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    // -----------------------------------------------------------------------------------------------------------------
    //
    // Auth Controller
    // Version 1
    //
    // -----------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json", headers = "X-API-Version=1")
    public ResponseEntity<EmailPasswordSignUpOrInResponseDto> signUp(@RequestBody EmailPasswordDto req) {
        EmailPasswordSignUpOrInResponseDto result = this.authService.emailPasswordSignUp(req.email(), req.password());
        if (result.status().equals("EMAIL_ALREADY_EXISTS_ERROR")) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json", headers = "X-API-Version=1")
//    public Mono<ResponseEntity<EmailPasswordSignUpOrInResponseDto>> signUp(@RequestBody EmailPasswordDto req) {
//        return this.authService.emailPasswordSignUp(req.email(), req.password()).map(result -> {
//            if (result.status().equals("EMAIL_ALREADY_EXISTS_ERROR")) {
//                return new ResponseEntity<>(result, HttpStatus.CONFLICT);
//            }
//
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        });
//    }

//    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json", headers = "X-API-Version=1")
//    public Mono<ResponseEntity<CreateSessionResponseDto<UserDataInJWT>>> signIn(@RequestBody EmailPasswordDto req) {
//        return this.authService.emailPasswordSignIn(req.email(), req.password()).map(result -> {
//            if (result.status().equals("WRONG_CREDENTIALS_ERROR")) {
//                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//            }
//
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            req.email(), req.password()
//                    )
//            );
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        });
//    }

    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json", headers = "X-API-Version=1")
    public ResponseEntity<EmailPasswordSignUpOrInResponseDto> signIn(@RequestBody EmailPasswordDto req) {
        EmailPasswordSignUpOrInResponseDto result = this.authService.emailPasswordSignIn(req.email(), req.password());
        if (result.status().equals("WRONG_CREDENTIALS_ERROR")) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
