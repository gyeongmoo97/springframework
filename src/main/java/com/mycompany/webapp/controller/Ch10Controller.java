package com.mycompany.webapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.exception.Ch10SoldOutException;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);

	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch10/content";
	}

	@RequestMapping("/handlingException1")
	public String handlingException1(String data) {
		logger.info("실행");
		try {
			if (data.equals("java")) {
				// NullPointerException
			}
		} catch (Exception e) {
			return "error/500_null";
		}
		return "redirect:/ch10/content";
	}
	// 예외처리 클래스를 작동시는 것을 테스트하기 위한 메서드
	@RequestMapping("/handlingException2")
	public String handlingException2(String data) {
		logger.info("실행");
		// 예외가 발생하도록 내버려둔다. 오히려 try catch 하면 안됨
		if (data.equals("java")) {
			// NullPointerException 발생
		}
		return "redirect:/ch10/content";
	}
	
	// 클래스 케스팅 예외를 발생시키켜 예외처리 클래스로 연결하는 것을 테스트하기 위한 메서드
	@RequestMapping("/handlingException3")
	public String handlingException3() {
		logger.info("실행");
		Object data = "abc";
		Date date = (Date) data; //ClassCastException발생 
		
		return "redirect:/ch10/content";
	}
	
	// 구체적인 예외가 없는 경우에 대한 처리를 확인하기 위한 메서드
	@RequestMapping("/handlingException4")
	public String handlingException4() {
		logger.info("실행");
		int [] arr = {1,2,3};
		arr[3] = 40; //ArrayIndexOutOfBoundsException 발생
		return "redirect:/ch10/content";
	}

	// 구체적인 예외가 없는 경우에 대한 처리를 확인하기 위한 메서드
	@RequestMapping("/handlingException5")
	public String handlingException5() {
		logger.info("실행");
		int stock = 0;
		if(stock == 0) {
		 
		 throw new Ch10SoldOutException("상품의 제고가 없습니다.");
		 // 생성자 중 message를 가지고 있는 생성자 사용 
//		 throw new Ch10SoldOutException(); -> 생성자 중 빈 생성자 호출
		}
	
		return "redirect:/ch10/content";
	}
}
