package com.batch.lcwd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//	@Before("execution(* com.batch.lcwd.controller.*.*())")
	public void loggingBeforeController() {
		System.out.println("Logs are taken down BEFORE controller getting a hit!");
	}

	@Around("execution(* com.batch.lcwd.controller.*.*())")
	public Object loggingAoundController(ProceedingJoinPoint joinPoint) {
		System.out.println("Before method: " + joinPoint.getSignature().getName());

		// Proceed with the original method call
		Object returnValue=null;
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("After method: " + joinPoint.getSignature().getName());
		return returnValue;
	}

//	@After("execution(* com.batch.lcwd.controller.*.*())")
	public void loggingAfterController() {
		System.out.println("Logs are taken AFTER controller getting a hit!");
	}
}
