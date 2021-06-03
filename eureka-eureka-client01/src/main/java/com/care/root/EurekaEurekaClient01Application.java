package com.care.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaEurekaClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaEurekaClient01Application.class, args);
	}
	
	@LoadBalanced
	@Bean
	WebClient.Builder loadBalanced(){
		return WebClient.builder();
	}
}

















