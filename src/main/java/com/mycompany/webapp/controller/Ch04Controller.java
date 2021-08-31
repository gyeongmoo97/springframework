package com.mycompany.webapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch04Member;
import com.mycompany.webapp.validator.Ch04MemberEmailValidator;
import com.mycompany.webapp.validator.Ch04MemberIdValidator;
import com.mycompany.webapp.validator.Ch04MemberJoinFormValidator;
import com.mycompany.webapp.validator.Ch04MemberPasswordValidator;
import com.mycompany.webapp.validator.Ch04MemberTelValidator;

@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);

	@RequestMapping("/content")
	public String content() {

		return "ch04/content";
	}

	@PostMapping("/method1")
	public String method1() {
		return "redirect:/ch04/content";
	}

//	
////	@InitBinder("ch04Member")
//	//form 단위
//	@InitBinder("joinForm")
//	public void joinFormSetValidator(WebDataBinder binder) {
//		logger.info("실행");
//		binder.setValidator(new Ch04MemberJoinFormValidator());
//	}
//	
//	
// //필드단위
	@InitBinder("joinForm")
	public void joinFormSetValidator(WebDataBinder binder) {
		logger.info("실행");
		binder.addValidators(
			new Ch04MemberIdValidator(),
			new Ch04MemberPasswordValidator(),
			new Ch04MemberEmailValidator(),
			new Ch04MemberTelValidator()
		);
	}

	// BindingResult 사용예제
	@PostMapping("/method2")
	// BindingResult bindingReult 유효성감사의 결과를 의미함 Errors error 이 와도됨. ppt 유효성 실패 저장
	// 파트임
	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member, BindingResult bindingReult) {
		logger.info("실행");
		if (bindingReult.hasErrors()) {
			logger.info("다시 입력폼 제공 + err msg");
			return "ch04/content";
		} else {
			logger.info("정상 요청 처리후 응답 제공");
			return "redirect:/ch04/content";
		}

	}

	// Errors 사용 예제
//	@PostMapping("/method2")
//	// BindingResult bindingReult 유효성감사의 결과를 의미함 Errors error 이 와도됨. ppt 유효성 실패 저장 파트임
//	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member, Errors error) {
//		logger.info("실행");
//		if(error.hasErrors()) {
//			logger.info("다시 입력폼 제공 + err msg");
//			return "ch04/content";
//		} else {
//			logger.info("정상 요청 처리후 응답 제공");
//			return "redirect:/ch04/content";
//		}
//		
//	}
//	

//	@PostMapping("/method2")
//	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member) {
//		logger.info("mid :" + member.getMid());
//		logger.info("mpassword : " + member.getMpassword());
//		logger.info("memail : " + member.getMemail());
//		logger.info("mtel : " + member.getMtel());
//		return "redirect:/ch04/content";
//	}
//	
//	@PostMapping("/method3")
//	public String login(@ModelAttribute("loginForm") @Valid Ch04Member member) {
//		logger.info("mid :" + member.getMid());
//		logger.info("mpassword : " + member.getMpassword());
//		return "redirect:/ch04/content";
//	}
//	

}
