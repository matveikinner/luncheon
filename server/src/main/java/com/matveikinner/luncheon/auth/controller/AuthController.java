package com.matveikinner.luncheon.auth.controller;

import com.matveikinner.luncheon.auth.dto.EmailPasswordDto;
import com.matveikinner.luncheon.auth.service.AuthService;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    // -----------------------------------------------------------------------------------------------------------------
    //
    // Auth Controller
    // Version 1
    //
    // -----------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json", headers = "X-API-Version=1")
    public Mono<ResponseEntity<EmailPasswordSignupinResponseDto>> signup(@RequestBody EmailPasswordDto req) {
        return this.authService.emailPasswordSignup(req.email(), req.password()).map(result -> {
            if (result.status().equals("EMAIL_ALREADY_EXISTS_ERROR")) {
                return new ResponseEntity<>(result, HttpStatus.CONFLICT);
            }

            return new ResponseEntity<>(result, HttpStatus.OK);
        });
    }
}
