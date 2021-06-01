package com.care.root.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.UrlDto;
import com.care.root.service.UrlService;

@RestController
public class UrlController {
	@Autowired UrlService us;
	@GetMapping("geturl")
	public ArrayList<UrlDto> getUrl(){
		return us.getUrl();
	}
}
