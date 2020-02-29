package com.springdemoweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoWebLogger {
	
	@Pointcut("within(com.springdemoweb.controller.*)") public void controllerPointcut() {}
	@Pointcut("within(com.springdemoweb.service.*)") public void servicePointcut() {}
	@Pointcut("within(com.springdemoweb.dao.*)") public void daoPointcut() {}

//	@Before("bean(*Dao) || bean(*Service) || within(com.springdemoweb.controller.*)")
//	public void doBefore(JoinPoint joinPoint) {
//		
//		System.out.printf("Before Execution %s.%s\n",
//			joinPoint.getSignature().getDeclaringTypeName(),
//			joinPoint.getSignature().getName());
//
//	}
	
	//@Around("controllerPointcut() || servicePointcut() || daoPointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		
		//do something here for before advice		
		
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable ex) {			
		}
		
		//do something here for after advice
		
		return returnValue;
	}
	
}












