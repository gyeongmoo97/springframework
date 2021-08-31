package com.mycompany.webapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

public class Ch04MemberJoinFormValidator implements Validator {
	//모든 데이터를 유효성검사할 수 없기 때문에 범위를 지정해야한다. 
	// 어떤 대상을 유효성검사할 수 있고 없고를 판단해서 유효성검사 가능한 대상이면 true 아니면 false됨
	//supports 의 arg로 dto가 들어간다.
	
	private static final Logger logger = LoggerFactory.getLogger(Ch04MemberJoinFormValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("실행");
		//여기에(clazz) 들어가는 클래스가 Ch04Member에 대입될 수 있는지
		boolean check = Ch04Member.class.isAssignableFrom(clazz);
		
		return check;
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("실행");
		Ch04Member member = (Ch04Member) target;
		
		//mid 검사
		//내용이 없는 경우
		if(member.getMid() ==null || member.getMid().trim().equals("")) {
			errors.rejectValue("mid","errors.mid.required");
		}else {
			if(member.getMid().length()<4) {
				errors.rejectValue("mid","errors.mid.minlength", new Object[] {4}, "");
			}
		}
		
		//mpassword 검사
		if(member.getMpassword() ==null || member.getMpassword().trim().equals("")) {
			errors.rejectValue("mpassword","errors.mpassword.required");
		} else {
			if(member.getMpassword().length()<8) {
				errors.rejectValue("mpassword","errors.mpassword.minlength", new Object[] {8}, "");
			}
		}
		
		//memail 검사
		//자바도 정규표현식으로 검사 가능하다.
		if(member.getMemail() ==null || member.getMemail().trim().equals("")) {
			errors.rejectValue("memail","errors.memail.required");
		} else {
			//js는 //로 감싸서 표현했는데 java는 문자열로 만들어서 검사한다. 
			//직접 작성하기보다는 일단은 인터넷 검색으로 넣는다
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			//위의str 정규식을 해석해서 pattern 이라는 객체를 만든다.
			Pattern pattern = Pattern.compile(regex);
			//pattern 객체관련 좀 알아보기
			Matcher matcher = pattern.matcher(member.getMemail());
			if(!matcher.matches()) {
				errors.rejectValue("memail","errors.memail.invalid");
			}
		}
		
		//mtel 검사
		if(member.getMtel() ==null || member.getMtel().trim().equals("")) {
			errors.rejectValue("mtel","errors.mtel.required");
		} else {
			String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(member.getMtel());
			if(!matcher.matches()) {
				errors.rejectValue("mtel","errors.mtel.invalid");
			}
		}
		//error 객체의 역할
		//error 객체에 아무것도 없다면? -> 에러가 없는것
		//error 객체에 무언가 있다면? -> 에러가 있으니 다시 입력하라는 form 을 띄울때 error 메시지 보여주기 가능
		
	}
	
}
