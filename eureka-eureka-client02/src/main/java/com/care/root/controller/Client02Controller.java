package com.care.root.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client02Controller {
	@Value("${server.port}") String port;
	int cnt;
	@GetMapping("getmessage")
	public String getMessage() throws InterruptedException {
		//Thread.sleep(2000);
		return cnt++ + "디비와 연산된 결과를 돌려줍니다.";
	}
}
