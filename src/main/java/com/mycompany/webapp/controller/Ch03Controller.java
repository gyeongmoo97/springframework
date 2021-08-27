package com.mycompany.webapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch03Dto;

@Controller
@RequestMapping("/ch03")
//requestMapping 앞에는 context root 가 생략되어있음 동적으로 할당 안해도된다.

public class Ch03Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch03Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("03실행");
		return "ch03/content";
	}
	
//	@GetMapping("/method1")
//	public String method1(
//			@RequestParam("param1")String p1,
//			@RequestParam("param2")String p2,
//			//같은 이름으로 작성하면 key로 작성해서 알아서 값 매칭된다.
//			String param3,
//			String param4,
//			String param5
//			) {
//		
//		logger.info("param1: " + param1);
//		logger.info("param2: " + param2);
//		logger.info("param3: " + param3);
//		logger.info("param4: " + param4);
//		logger.info("param5: " + param5);
//
//		return "redirect:/ch03/content";
//	}
	
	
	
	@GetMapping("/method1")
	public String method1(Ch03Dto dto) {
		/// 매개변수명이 parameter 과 같은 값이여야한다.
		logger.info("param1: " + dto.getParam1());
		logger.info("param2: " + dto.getParam2());
		logger.info("param3: " + dto.getParam3());
		logger.info("param4: " + dto.isParam4());
		//boolean 타입의 getter 는 is 로 시작함.
		logger.info("param5: " + dto.getParam5());
	

		return "redirect:/ch03/content";
	}
	
	
//	@PostMapping("/method2")
//	public String method2(
//			String param1,
////			String param2,
//			@RequestParam(defaultValue="0")	int param2,
////			String param3,
//			@RequestParam(defaultValue="0.0")	double param3, 
////			String param4,
//			@RequestParam(defaultValue="false")boolean param4,
//			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5
//			) {
//		logger.info("param1: " + param1);
//		logger.info("param2: " + param2);
//		logger.info("param3: " + param3);
//		logger.info("param4: " + param4);
//		logger.info("param5: " + param5);
//		
//		return"redirect:/ch03/content";
//	}
	
	@PostMapping("/method2")
	public String method2(Ch03Dto dto) {
		/// 매개변수명이 parameter 과 같은 값이여야한다.
		logger.info("param1: " + dto.getParam1());
		logger.info("param2: " + dto.getParam2());
		logger.info("param3: " + dto.getParam3());
		logger.info("param4: " + dto.isParam4());
		//boolean 타입의 getter 는 is 로 시작함.
		logger.info("param5: " + dto.getParam5());
	

		return "redirect:/ch03/content";
	}
	
}
