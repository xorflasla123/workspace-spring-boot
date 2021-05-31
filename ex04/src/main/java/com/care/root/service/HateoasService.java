package com.care.root.service;

import java.util.ArrayList;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.care.root.dto.HateoasDTO;

@Service
public class HateoasService {
	ArrayList<HateoasDTO> users;
	public ArrayList<HateoasDTO> getUserList(){
		HateoasDTO user01 = new HateoasDTO("1", "홍길동", "산골짜기");
		HateoasDTO user02 = new HateoasDTO("2", "고길동", "마포구");
		HateoasDTO user03 = new HateoasDTO("3", "김개똥", "바닷가");
		users = new ArrayList<HateoasDTO>();
		users.add(user01);
		users.add(user02);
		users.add(user03);
		return users;
	}
	public HateoasDTO getUser(String id) {
		for(HateoasDTO d : users) {
			if(id.equals(d.getUserId())) {
				return d;
			}
		}
		return null;
	}
	public HateoasDTO getHateoas() {
		HateoasDTO url = new HateoasDTO();
		url.setName("홈");
		url.setAddr("게시판");
		url.setUserId("멤버");
		
		Link link = Link.of("http://localhost:8087/");
		url.add(link.withSelfRel()); //기본경로 self
		
		link = Link.of("http://localhost:8087/board"+url.getAddr());
		url.add(link.withRel("board")); //경로 이름 board
		
		link = Link.of("http://localhost:8087/member/");
		url.add(link.withRel("member")); //경로 이름 member
		
		return url;
	}
}












