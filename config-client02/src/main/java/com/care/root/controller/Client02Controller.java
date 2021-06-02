package com.care.root.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client02Controller {
	@Value("${server.port}")
	String port;
	@Value("${test.name}")
	String name;

	@RequestMapping("/")
	public String index() {
		return "깃허브에서 가져온 값 : " + port + " : " + name;
	}
}
