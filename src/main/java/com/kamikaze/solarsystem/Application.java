package com.kamikaze.solarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.kamikaze.solarsystem")
@EnableJpaRepositories("com.kamikaze.solarsystem")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
