package com.mycompany.webapp.aspect;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
public class Ch15Aspect7Around {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect7Around.class);
	
	
	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.boardList(..))")
	public Object boardList(ProceedingJoinPoint joinPoints) throws Throwable {
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sessionMid");
		logger.info("mid ::: +"+mid);
		logger.info("---------------------------------------------------------");
		HttpServletResponse response = sra.getResponse();
		
		if(mid==null) {
			JSONObject jo = new JSONObject();
			jo.put("result", "needToLogin");
			String json =jo.toString();
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			
			pw.write(json);
			pw.flush();
			pw.close();
	
			return null;
		}else {
			Object result = joinPoints.proceed();
			
			return result;
		}
		
		
//		
	
	}
}
