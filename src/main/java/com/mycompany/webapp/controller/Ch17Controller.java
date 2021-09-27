package com.mycompany.webapp.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.JoinResult;

@Controller
@RequestMapping("/ch17")
public class Ch17Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);

	@RequestMapping("/content")
	public String content() {

		return "ch17/content";
	}

	@RequestMapping("/loginForm")
	public String loginForm() {

		return "ch17/loginForm";
	}

	@RequestMapping("/adminAction")
	public String adminAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}

	@RequestMapping("/managerAction")
	public String managerAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}

	@RequestMapping("/userAction")
	public String userAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}

	@RequestMapping("/error403")
	public String error403() {
		logger.info("실행");
		return "ch17/error403";
	}

	@RequestMapping("/joinForm")
	public String joinForm() {
		logger.info("실행");
		return "ch17/joinForm";
	}
 
	@Resource
	Ch14MemberService memberServiceDao;

	@RequestMapping("/join")
	public String join(Ch14Member member, Model model) {
		logger.info("실행");

		member.setMenabled(1);
		
		//패스워드 암호화
		String mpassword = member.getMpassword();
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		mpassword = "{bcrypt}"+bpe.encode(mpassword);

		member.setMpassword(mpassword);

		JoinResult jr = memberServiceDao.join(member);
		if (jr == JoinResult.SUCCESS) {
			return "redirect:/ch17/loginForm";
		} else if (jr == JoinResult.DUPLICATED) {
			model.addAttribute("error", "중복된 아이디를 입력했습니다.");
			return "/ch17/joinForm";
		} else {
			model.addAttribute("error", "회원 가입이 실패되었습니다. 다시 시도해 주세요.");
			return "/ch17/joinForm";
		}
	}
	
	@RequestMapping(value="userInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String userInfo(Authentication authentication) {
		logger.info("실행");
		
		//로그인이 되었는지 확인을 하려면? 스프링 시큐리티가 관리하고있어서 거기서 정보를 얻어야 한다.
		//SecurityContext 는 스프링 시큐리티 에서 인증정보를 관리하는 관리빈, 컨테이너 정도로 생각하면됨  ***핵심적인 정보를 가지고 있음
//		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		//인증 정보 객체를 얻기 관리빈이다.
//		Authentication authentication = securityContext.getAuthentication();
		
		// ++ 관리빈이라서 그냥 매개변수로 받아서 사용가능함. 그때는 SecurityContext 안써도된다.
		
		
		
		//사용자 식별값(로그인 할때 사용한 id, email)얻기
		String mid = authentication.getName();
		
//		authentication.getAuthorities();
		//여러가지 권한이 있을 수 있다. 그래서 컬렉션으로 리턴한다.
		/*
		 Returns:the authorities granted to the principal, or an empty collection if thetoken has not been authenticated. Never null.
		 */
		
		//사용자 권한(롤) 이름 얻기
		List<String> authorityList = new ArrayList();
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			authorityList.add(authority.getAuthority());
		}
		
		//사용자가 로그인 상세정보에서 PC의 IP 주소 얻기
		WebAuthenticationDetails wad = (WebAuthenticationDetails) authentication.getDetails();
		String ip = wad.getRemoteAddress();
		
		//Holder는 무언가를 가지고 있는 녀석 , 보통 holder면 정적메서드를 사용한다.		
		
		JSONObject jo = new JSONObject();
		jo.put("mid", mid);
		jo.put("mrole", authorityList);
		jo.put("ip", ip);
		
		
		String json = jo.toString();
		
		return json;
	}
	
	
	
	
	
	
}
