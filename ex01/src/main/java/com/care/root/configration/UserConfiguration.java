package com.care.root.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
	@Bean
	public UserTest userTest() {
		return new UserTest();
	}
}
