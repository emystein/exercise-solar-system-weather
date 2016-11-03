package com.mercadolibre.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.mercadolibre.galaxy")
@EnableJpaRepositories("com.mercadolibre.galaxy")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
