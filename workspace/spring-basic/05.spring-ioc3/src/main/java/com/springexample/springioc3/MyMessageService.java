package com.springexample.springioc3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageService")
@Scope(BeanDefinition.SCOPE_SINGLETON) //@Scope("singleton")
public class MyMessageService implements MessageService {
	
	int data;
	public MyMessageService() {
		data = (int)(Math.random() * 900) + 100;
	}
	
	public String getMessage() {
		return "Hello, Spring IoC Container !!!" + data;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("MyMessageService.init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("MyMessageServce.destroy()");
	}

}
