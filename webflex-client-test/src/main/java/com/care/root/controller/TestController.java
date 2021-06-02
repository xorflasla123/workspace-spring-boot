package com.care.root.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class TestController {
	String serverURL = "http://localhost:12000/server";
	RestTemplate template = new RestTemplate();
	@RequestMapping("/index")
	public String index() {
		String sendData = "11000에서 전송";
		/*******  한글깨짐 처리 *******/
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(
				new MediaType("application", "json", Charset.forName("UTF-8")));
		HttpEntity<String> name = new HttpEntity<>(sendData, headers);
		/*********************************************/
		System.out.println("==== 11000 index 실행 ====");
		StopWatch sw = new StopWatch();
		sw.start();
		String s = template.postForObject( serverURL, name, String.class );
		sw.stop();
		System.out.println("수행 시간 : "+sw.getTotalTimeSeconds()+" 초 걸림");
		System.out.println("12000 return value : "+s);
		System.out.println("==== 11000 index 종료 ====");
		return s;
	}
	
	@RequestMapping("/index2")
	public String index2() {
		String sendData = "11000에서 전송";
		/*******  한글깨짐 처리 *******/
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(
				new MediaType("application", "json", Charset.forName("UTF-8")));
		HttpEntity<String> name = new HttpEntity<>(sendData, headers);
		/*********************************************/
		System.out.println("==== 11000 index 실행 ====");
		StopWatch sw = new StopWatch();
		sw.start();
		WebClient webClient = WebClient.create();
		Mono<String> s = webClient.post()
				.uri(serverURL).body(BodyInserters.fromValue("test"))
				.retrieve() //request를 만들고 http request를 보내는 역할
				.bodyToMono(String.class);
		//응답 값 받아서 처리해주는 부분
		// 비동기이기 때문에 12000응답으 늦게 도달할 수 있다.
		s.subscribe(result -> {
			System.out.println("12000 return value : "+result);
		});
		sw.stop();
		System.out.println("수행 시간 : "+sw.getTotalTimeSeconds()+" 초 걸림");
		System.out.println("12000 return value : "+s);
		System.out.println("==== 11000 index 종료 ====");
		return "11000번 실행 됨";
	}
}
