package com.jdriascos.casoba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jdriascos")
public class CasobaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasobaApplication.class, args);
	}
}
