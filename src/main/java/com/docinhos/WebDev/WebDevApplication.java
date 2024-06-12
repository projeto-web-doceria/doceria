package com.docinhos.webdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebDevApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
