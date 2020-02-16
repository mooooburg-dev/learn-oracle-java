package com.springexample.springioc4;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //IoC 컨테이너의 빈 설정을 관리하는 클래스로 지정
public class MyBeanConfig {
		
	@Bean //<bean id="" or @Comonent(""
	public ServiceConsumer serviceConsumer(SimpleDateFormat format) {//컨테이너에 등록된 빈을 암시적으로 의존성 주입 == @AutoWired
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		serviceConsumer.setMessageService(messageService()); //다른 @Bean 메서드를 호출해서 의존성 주입
		serviceConsumer.setTimeService(timeService(format));//다른 @Bean 메서드를 호출해서 의존성 주입
		return serviceConsumer;
	}
	
	@Bean
	public MessageService messageService() {
		return new MyMessageService();
	}
	
	@Bean
	public TimeService timeService(SimpleDateFormat format) { //컨테이너에 등록된 빈을 암시적으로 의존성 주입
		MyTimeService timeService = new MyTimeService();
		timeService.setFormat(format);
		return timeService;
	}

}




