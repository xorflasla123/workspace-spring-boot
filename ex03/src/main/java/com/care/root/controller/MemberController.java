package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.dto.TestDto;
import com.care.root.service.TestService;

@Controller
public class MemberController {
	@Autowired
	TestService service;
	
	@GetMapping("members")
	public String getMemers(Model model) {
		service.getMembers(model);
		return "members";
	}
	@GetMapping("member")
	public String getMember(@RequestParam int id, Model model) {
		model.addAttribute("member", service.getMember(id));
		return "member";
	}
	@GetMapping("saveview")
	public String saveView() {
		return "saveview";
	}
	@PostMapping("save")
	public String insert(TestDto member) {
		service.save(member);
		return "redirect:/members";
	}
	@GetMapping("delete")
	public String delete(@RequestParam int id) {
		service.delete(id);
		return "redirect:/members";
	}
	@GetMapping("modifyview")
	public String modifyView(@RequestParam int id, Model model) {
		model.addAttribute("member", service.getMember(id) );
		return "modifyview";
	}
	@PostMapping("modify")
	public String modify(TestDto dto) {
		service.modify(dto);
		return "redirect:member?id="+dto.getId();
	}
}












