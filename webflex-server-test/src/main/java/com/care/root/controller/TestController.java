package com.care.root.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("server")
    public String postMethod(@RequestBody String s) {
    	System.out.println("12000번 포트 server 실행");
    	try {
			Thread.sleep(5000);
		} catch (Exception e) {  }
		System.out.println("11000로 부터 송신 데이터 : "+s);
		System.out.println("12000번 포트 server 종료");
		return "12000에서 전송한 값입니다";
    }
}
