package com.springdemoweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect		// 이 클래스가 AOP를 위한 Aspect임을 알려주는 annotation
@Component
public class DemoWebLogger {
	
	@Pointcut("within(com.springdemoweb.controller.*)") public void controllerPointcut() {}
	@Pointcut("within(com.springdemoweb.service.*)") public void servicePointcut() {}
	@Pointcut("within(com.springdemoweb.dao.*)") public void daoPointcut() {}

//	@Before("bean(*Dao) || bean(*Service) || within(com.springdemoweb.controller.*)")
	public void doBefore(JoinPoint joinPoint) {
		
		System.out.printf("Before Execution %s.%s\n",
			joinPoint.getSignature().getDeclaringTypeName(),
			joinPoint.getSignature().getName());

	}
	
	@Around("controllerPointcut() || servicePointcut() || daoPointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		
		//do something here for before advice
		long begin = System.currentTimeMillis();
		
		Object returnValue = null;
		try {
			// 실제 메서드 호출 구문
			returnValue = joinPoint.proceed();
		} catch (Throwable ex) {			
		}
		
		//do something here for after advice
		long end = System.currentTimeMillis();
		
		System.out.println(joinPoint.getSignature().getName() + " : "  + (end - begin));
		return returnValue;
	}
	
}












