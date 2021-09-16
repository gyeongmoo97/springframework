package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Ch15Aspect5AfterThrowing {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect5AfterThrowing.class);
	
	//pointcut의 메서드가 정상 종료 되었을 때 실행된다.
	//매개값이 필요하다. 근데 왜 이러한 정상종료시 시행하는걸 사용하나 ->
	@AfterThrowing(
			throwing = "e" ,
		pointcut = "execution(public * com.mycompany.webapp.controller.Ch15Controller.afterThrowing*(..))")
	public void method(Exception e) {
		logger.info("afterThrowing");
		logger.info("Throwable e : " + e);
	}
}
