package com.care.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.dao.TestDao;
import com.care.root.dto.TestDto;

@Service
public class TestService {
	@Autowired
	TestDao dao;
	public void getMembers(Model model) {
		model.addAttribute("members",dao.getMembers());
	}
	public TestDto getMember(int id) {		
		return dao.getMember(id);
	}
	public void save(TestDto dto) {
		dao.save(dto);
	}
	public void delete(int id) {
		dao.delete(id);
	}
	public void modify(TestDto dto) {
		dao.modify(dto);
	}
}







