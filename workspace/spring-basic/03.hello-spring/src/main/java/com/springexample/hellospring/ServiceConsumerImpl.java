package com.springexample.hellospring;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ServiceConsumerImpl implements ServiceConsumer {

	@Override
	public void doSomething() {
		
		//Factory 클래스 역할 (객체의 생성, 수명주기, 의존성 관리 컨테이너)
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("app-context.xml");
		MessageService messageService = factory.getBean("messageService", MessageService.class);
		
		String message = messageService.makeMessage();
		System.out.println(message);
	}

}
