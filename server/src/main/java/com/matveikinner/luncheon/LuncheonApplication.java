package com.matveikinner.luncheon;

import com.matveikinner.luncheon.config.LuncheonConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LuncheonConfigurationProperties.class)
public class LuncheonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuncheonApplication.class, args);
	}

}
