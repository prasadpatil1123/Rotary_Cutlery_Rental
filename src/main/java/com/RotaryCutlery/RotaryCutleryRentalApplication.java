package com.RotaryCutlery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.RotaryCutlery.model") 
public class RotaryCutleryRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RotaryCutleryRentalApplication.class, args);
	}

}
