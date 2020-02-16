package com.springexample.springioc3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("serviceConsumer") // default-id : myServiceConsumer (소문자로 시작하는 클래스 이름)
@Scope("prototype")
public class MyServiceConsumer implements ServiceConsumer {

	@Autowired //컨테이너에 등록된 빈 중에서 이 변수에 적합한 빈을 의존성 주입하는 명령
	@Qualifier("messageService") //id가 messageService인 빈을 의존성 주입하는 명령
	private MessageService messageService; //= new MyMessageService()
	
	public MyServiceConsumer() {}
	public MyServiceConsumer(MessageService messageService) {
		this.messageService = messageService;
	}			

	public MessageService getMessageService() {
		return messageService;
	}
	//@Autowired //컨테이너에 등록된 빈 중에서 이 변수에 적합한 빈을 의존성 주입하는 명령
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	//////////////////////////////////////////
	@Autowired
	@Qualifier("timeService")
	private TimeService timeService; //= new MyTimeService();
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public void doSomething() {
		String message = messageService.getMessage();
		System.out.println(message);
		message = timeService.getTimeString();
		System.out.println(message);
	}

}
