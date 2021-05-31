package com.care.root.custom;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageCustom {
	@RabbitListener(queues = "TestQueue")
	public void proccessMessage(String content) {
		try {
			System.out.println("이메일 전송 시작");
			Thread.sleep(10000);
			System.out.println("이메일 전송 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
