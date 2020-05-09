package com.infogain.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = ClientConfig.class)
public class MovieRecommendationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationClientApplication.class, args);
	}

}
