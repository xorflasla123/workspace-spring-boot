package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.service.TestService;

@RestController
public class TestRestController {
	@Autowired TestService ts;
	@GetMapping("test/{message}")
	public String test(@PathVariable String message) {
		ts.runner(message);
		return "돌려주는 값 : "+message;
	}
}
