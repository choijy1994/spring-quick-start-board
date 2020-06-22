package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("사전 처리");
		Object returnObj = pjp.proceed();
		System.out.println("사후 처리");
		return returnObj;
	}
}
