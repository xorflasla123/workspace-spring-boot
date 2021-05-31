package com.care.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.producer.MessageProducer;

@Service
public class TestService {
	@Autowired MessageProducer mp;
	public void runner(String message) {
		mp.send(message);
	}

}
