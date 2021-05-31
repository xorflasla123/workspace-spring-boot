package com.care.root.custom;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageCustom {
	@RabbitListener(queues = "TestQueue")
	public void proccessMessage(String content) {
		System.out.println(">>>> content : "+content);
	}
}
