package com.mycompany.webapp.aspect;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class Ch15Aspect8Around {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect8Around.class);

	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.boardList1(..))")
	public Object loginCheckAdvice1(ProceedingJoinPoint joinPoint) throws Throwable {
		// ----------------
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sessionMid");
		if (mid == null) {
			
//			String result= "redirect:/ch15/login"; //ajax 라서 리다이렉트 자제
//			
//			
//			HttpServletResponse response = sra.getResponse();
//			response.setContentType("application/json; charset=UTF-8");
//			
//			
////			request.setAttribute("loginCheck", false);
//			JSONObject jo = new JSONObject();
//			
//			
//			jo.put("result", "authFail");
//			String json = jo.toString();
//			
//			PrintWriter pw = response.getWriter();
//			pw.write(json);
//			pw.close();
//			
//			
//			return null;
			return "ch15/authFail";
		}else {
//			request.setAttribute("loginCheck", true);
			Object result = joinPoint.proceed(); // 보드리스트를 호출하는 코드 위의 코드는 제이슨만 보낸다.
			// ojbect 가 return 하는 result?? -> boardList 가 실행되고 그 값이 리턴된다. 즉 jsp의 뷰 이름이 리턴된다.
			return result;
		}
		
	}
	
	
	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.boardList2(..))")
	public Object loginCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// ----------------
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sessionMid");

		if (mid == null) {
			JSONObject jo = new JSONObject();
			jo.put("result", "authFail");
			String json = jo.toString();
			HttpServletResponse response = sra.getResponse();
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.close();
			return null;
//			request.setAttribute("loginCheck", false);
		}else {
//			request.setAttribute("loginCheck", true);
			Object result = joinPoint.proceed();
			return result;
		}
		 // 보드리스트를 호출하는 코드 위의 코드는 제이슨만 보낸다.
		// ojbect 가 return 하는 result?? -> boardList 가 실행되고 그 값이 리턴된다. 즉 jsp의 뷰 이름이 리턴된다.
		
//		
	}
}
