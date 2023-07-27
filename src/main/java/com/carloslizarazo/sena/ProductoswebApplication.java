package com.carloslizarazo.sena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.carloslizarazo.sena")
public class ProductoswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoswebApplication.class, args);
	}

}
