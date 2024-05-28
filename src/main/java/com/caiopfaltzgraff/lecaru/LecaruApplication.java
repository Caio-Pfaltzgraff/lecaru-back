package com.caiopfaltzgraff.lecaru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LecaruApplication {

	public static void main(String[] args) {
		SpringApplication.run(LecaruApplication.class, args);
	}

}
