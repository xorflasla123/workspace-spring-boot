package com.care.root.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
	@Autowired RabbitMessagingTemplate template;
	
	@Bean
	Queue queue() {
		return new Queue("TestQueue", false); //false = 임시저장(RAM), true = 완전저장(디스크)
	}
	
	public void send(String message) {
		template.convertAndSend("TestQueue",message);
	}

}
