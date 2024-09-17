package com.sikar.tamilSchoolP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TamilSchoolPApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamilSchoolPApplication.class, args);
	}

}
