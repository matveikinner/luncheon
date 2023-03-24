package com.matveikinner.luncheon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "supertokens")
public record LuncheonConfigurationProperties(String url, String version, String apiKey) {
}
