package com.care.root.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.dto.TestDTO;

@Controller
public class CommonController {
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index(Model model) {
		session.setAttribute("user", "session_value");
		model.addAttribute("user", "model_value");
		
		System.out.println(" 안녕하세요 ");
		return "index";
	}
	@RequestMapping("object")
	public String object(Model model) {
		TestDTO dto = new TestDTO();
		dto.setName("s 홍길동"); dto.setAddr("s 산골짜기");
		
		TestDTO mDto = new TestDTO();
		mDto.setName("m 홍길동"); mDto.setAddr("m 산골짜기");
		
		session.setAttribute("user", dto);
		model.addAttribute("user", mDto);
		
		String message = "<script>alert('안녕하세요')</script><h1>test</h1>";
		model.addAttribute("msg", message);
		
		return "object";
	}
	
	@GetMapping("operator/{num}")
	public ModelAndView operator(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("operator");
		List<String> arr = new ArrayList<String>();
		arr.add("홍길동");
		arr.add("김개똥");
		arr.add("고길동");
		mav.addObject("arr",arr); 
		mav.addObject("num", num);
		mav.addObject("name","김말이");
		return mav;
		
	}
	@RequestMapping("content")
	public String content(Model model) {
		model.addAttribute("test","test123");
		return "content";
	}
}





