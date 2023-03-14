package com.matveikinner.luncheon.auth.controller;

import com.matveikinner.luncheon.auth.dto.EmailPasswordDto;
import com.matveikinner.luncheon.auth.service.AuthService;
import com.matveikinner.luncheon.supertokens.dto.EmailPasswordSignupinResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private Environment env;

    private final AuthService authService;

    @GetMapping("/test")
    public String test() {
        log.info("Testing environmental variables {}", env.getProperty("variables.supertokens.version"));

        return "Hello";
    }

    @PostMapping("/signup")
    public Mono<EmailPasswordSignupinResponseDto> signup(@RequestBody EmailPasswordDto req) {
        return this.authService.emailPasswordSignup(req.email(), req.password());
    }
}
