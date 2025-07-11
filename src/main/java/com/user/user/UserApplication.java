package com.user.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

		System.out.println("User service Started...");
	}

}
