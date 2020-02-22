package com.springexample.springioc2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService2;
	private MessageService messageService; //= new MyMessageService()
	
	public MyServiceConsumer() {}
	public MyServiceConsumer(MessageService messageService) {
		this.messageService = messageService;
	}			

	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public void setMessageService2(MessageService messageService) {
		this.messageService2 = messageService;
	}
	
	//////////////////////////////////////////
	
	private TimeService timeService; //= new MyTimeService();
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public void doSomething() {
		String message2 = messageService2.getMessage();
		String message = messageService.getMessage();
		System.out.println(message);
		message = timeService.getTimeString();
		System.out.println(message);
	}

}
