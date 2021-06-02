package com.care.root.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RefreshScope
@RestController
public class Client01Controller {
	@Value("${server.port}")
	String port;
	@Value("${test.name}")
	String name;

	@RequestMapping("/")
	public String index() {
		return "깃허브에서 가져온 값 : " + port + " : " + name;
	}
	
	@RequestMapping("refresh")
	public void refresh() {
		WebClient webClient = WebClient.create();
		String configServerURL = "http://localhost:9000/actuator/refresh";
		webClient.post().uri(configServerURL).retrieve().
						bodyToMono(Object.class).subscribe();
	}
}
