package com.matveikinner.luncheon.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        log.debug("[JwtAuthenticationFilter] authorizationHeader: {}", authorizationHeader);

        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            String token = authorizationHeader.substring(TOKEN_PREFIX.length());

            log.debug("[JwtAuthenticationFilter] token: {}", token);
        }

        filterChain.doFilter(request, response);
    }
}
