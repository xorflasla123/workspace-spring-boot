package com.care.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.care.root.email.Mailer;

@Service
public class TestService {
	@Autowired Mailer mailer;
	public void register(String email) {
		StopWatch watch = new StopWatch();
		watch.start();
		mailer.sendMail(email);
		watch.stop();
		System.out.println(watch.getTotalTimeSeconds());
		System.out.println(watch.prettyPrint());
	}

}
