package com.springexample.springioc2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		//1.
		//MyServiceConsumer consumer = new MyServiceConsumer();
		
		//2.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("app-context.xml");
		
		ServiceConsumer consumer = container.getBean("serviceConsumer", ServiceConsumer.class);		
		consumer.doSomething();
		
		consumer = container.getBean("serviceConsumer2", ServiceConsumer.class);		
		consumer.doSomething();

	}

}


















