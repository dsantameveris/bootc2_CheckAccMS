package com.everis.CheckAccMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CheckAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckAccountApplication.class, args);
	}

}
