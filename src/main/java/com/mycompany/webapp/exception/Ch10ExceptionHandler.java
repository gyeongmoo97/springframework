package com.mycompany.webapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycompany.webapp.controller.Ch10Controller;

//예외처리 클래스를작성했다고 스프링에게 알려줘야한다.

//스프링에게 was가 시작될 때 IoC 컨테이너에 미리 해당 클래스의 객체를 만들어 
//두어서 사용할 수 있게 만ㄷ늘어 달라는 의미의 어노테이션
@Component
//모든 컨트롤러와 관련이 있게 된다. 모든 컨트롤러에게 관여 가능한 클래스가 된다.
//모든 컨트롤러에게 영향을 미치는 클래스를 만들기 위해 설정
@ControllerAdvice
public class Ch10ExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(Ch10ExceptionHandler.class);

	public Ch10ExceptionHandler() {
		logger.info("실행");
		
	}

	// 예외 처리자 설정
	@ExceptionHandler
	public String handleNullPointerException(NullPointerException e) {
		logger.info("실행");
		return "error/500_null";
	}

	// 타입변환 오류
	@ExceptionHandler
	public String handleClassCastException(ClassCastException e) {
		logger.info("실행");
		e.printStackTrace();
		return "error/500_cast";
	}

	// 스프링은 구체적인 예외상황을 다 찾을 후에 포괄적인 예외 상황을 처리한다.
//	runtimeException 으로 나머지 상황을 다 처리 가능하다.
	// Exception에 RuntimeException이 포함된다.
	@ExceptionHandler
//	public String handleClassCastException(RuntimeException e) {
	public String handleException(Exception e) {
		logger.info("실행");
		e.printStackTrace();
		return "error/500";
	}
	
	@ExceptionHandler
//	public String handleClassCastException(RuntimeException e) {
	public String handleCh10SoldOutException(Ch10SoldOutException e) {
		logger.info("실행");
		e.printStackTrace();
		return "error/soldout";
	}
	
	@ExceptionHandler
//	public String handleClassCastException(RuntimeException e) {
	public String handleCh16NotFoundAccoutException(Ch16NotFoundAccoutException e, Model model) {
		logger.info("실행");
		e.printStackTrace();
		model.addAttribute("error", e.getMessage());
		return "error/notFoundAccountException";
	}
	

}
