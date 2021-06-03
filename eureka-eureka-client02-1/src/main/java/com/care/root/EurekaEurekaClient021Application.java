package com.care.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaEurekaClient021Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaEurekaClient021Application.class, args);
	}

}
