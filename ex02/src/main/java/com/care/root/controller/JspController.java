package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
	@GetMapping("test")
	public String test() {
		return "test";
	}
}
