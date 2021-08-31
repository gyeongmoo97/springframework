package com.mycompany.webapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

public class Ch04MemberEmailValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(Ch04MemberEmailValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("실행");
		boolean check = Ch04Member.class.isAssignableFrom(clazz);
		return check;
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("실행");
		Ch04Member member = (Ch04Member) target;

		// memail 검사
		// 자바도 정규표현식으로 검사 가능하다.
		if (member.getMemail() == null || member.getMemail().trim().equals("")) {
			errors.rejectValue("memail", "errors.memail.required");
		} else {
			// js는 //로 감싸서 표현했는데 java는 문자열로 만들어서 검사한다.
			// 직접 작성하기보다는 일단은 인터넷 검색으로 넣는다
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			// 위의str 정규식을 해석해서 pattern 이라는 객체를 만든다.
			Pattern pattern = Pattern.compile(regex);
			// pattern 객체관련 좀 알아보기
			Matcher matcher = pattern.matcher(member.getMemail());
			if (!matcher.matches()) {
				errors.rejectValue("memail", "errors.memail.invalid");
			}
		}
	}

}
