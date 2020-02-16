package com.springexample.hellospring;

import java.lang.reflect.Method;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		//ServiceConsumer serviceConsumer = new ServiceConsumerImpl();
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("app-context.xml");
		ServiceConsumer serviceConsumer = factory.getBean("serviceConsumer", ServiceConsumer.class);
		//ServiceConsumer serviceConsumer = (ServiceConsumer)factory.getBean("serviceConsumer");
		serviceConsumer.doSomething();
		
//		Class claz = ServiceConsumer.class;
//		Method[] methods = claz.getDeclaredMethods();
//		System.out.println("METHOD NAME: " + methods[0].getName());
	}

}




