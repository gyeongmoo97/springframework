package com.mycompany.webapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Ch15Aspect6Around {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect6Around.class);
	
	
	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.around*(..))")
	public Object method(ProceedingJoinPoint joinPoints) {
		//무조건 리턴타입은 Object 매개변수로 ProceedingJoinPoint
		logger.info("around 전처리 실행");
		//----------------
		Object result=null;
		try {
			result = joinPoints.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//----------------
		logger.info("around 후처리 실행");
		return result;
	}
}
