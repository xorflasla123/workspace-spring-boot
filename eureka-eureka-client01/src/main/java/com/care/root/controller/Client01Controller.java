package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Client01Controller {
	String eurekaURL = "http://EUREKACLIENT02-TEST/getmessage";
	@Autowired WebClient.Builder webClient;
	@GetMapping("/")
	public String eurekaClient(Model model) {
		String s = webClient.build().get().uri(eurekaURL)
				.retrieve().bodyToMono(String.class).block();
		model.addAttribute("s",s);
		return "index";
	}
}
