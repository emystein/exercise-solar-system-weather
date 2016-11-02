package com.mercadolibre.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mercadolibre.galaxy")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
