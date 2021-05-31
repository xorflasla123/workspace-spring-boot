package com.care.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.HateoasDTO;
import com.care.root.service.HateoasService;

@RestController // page가 아니라 data를 돌려주는 방식
public class HateoasRestController {
	@Autowired
	HateoasService hs;
	@RequestMapping("users")
	public List<HateoasDTO> getUser() {
		List<HateoasDTO> users = hs.getUserList();
		return users;
	}
	@GetMapping("user/{id}")
	public HateoasDTO getUser(@PathVariable String id) {
		return hs.getUser(id);
	}
	
	@RequestMapping("gethateoas")
	public HateoasDTO getHateoas() {
		return hs.getHateoas();
	}
}
