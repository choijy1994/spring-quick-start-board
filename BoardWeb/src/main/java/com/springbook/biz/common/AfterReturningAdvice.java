package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp,Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("s")) {
				System.out.println(user.getName()+" 로그인" );
			}
		}
		System.out.println("[사후 처리]" + method + "()" + returnObj.toString());
	}
}
