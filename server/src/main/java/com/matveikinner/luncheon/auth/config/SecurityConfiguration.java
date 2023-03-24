package com.matveikinner.luncheon.auth.config;


import com.matveikinner.luncheon.auth.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Value("${some.key:http://localhost:3000}")
    private List<String> corsOrigins;

    private static final String[] OPEN_ENDPOINTS = {
            "/api/auth/signup",
            "/api/auth/signin"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // by default uses a Bean by the name of corsConfigurationSource
                // See https://docs.spring.io/spring-security/reference/servlet/integrations/cors.html
                //.cors(withDefaults())
                .cors(AbstractHttpConfigurer::disable)
                // See See https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html
                .csrf(config -> {
                    // See https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html#servlet-csrf-configure-request-handler
                    // config.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler());
                    // Set "cookieHttpOnly" value as false to expose / allow reading the CSRF token value in JavaScript
                    config.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                    config.ignoringRequestMatchers(OPEN_ENDPOINTS);
                })
                .authorizeHttpRequests(config -> {
                    config.requestMatchers("/api/auth/**", "/stomp/**").permitAll();
                    config.requestMatchers(OPEN_ENDPOINTS).permitAll();
                    config.anyRequest().authenticated();
                })
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // .authenticationProvider(authenticationProvider)
                // .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(this.corsOrigins);
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Content-Type", "Authorization", "X-CSRF-TOKEN", "X-XSRF-TOKEN", "X-API-Version"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/api/**", configuration);

        return source;
    }
}
