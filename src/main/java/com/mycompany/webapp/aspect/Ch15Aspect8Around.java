package com.mycompany.webapp.aspect;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.boardList(..))")
	public Object loginCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// ----------------
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sessionMid");
		if (mid == null) {
			JSONObject jo = new JSONObject();
			jo.put("reslut", "loginNeed");
			String json = jo.toString();
			HttpServletResponse response = sra.getResponse(); // aspect 에서 response 얻는법
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println(json);
			pw.flush();
			pw.close();
			// 여기는 null 이라는 view 를 리턴한다. 그러면 포워딩 일어나지 않는다.
			//json 이 response 에 들어간다.
			return null;

		} else {

			Object result = joinPoint.proceed(); // 보드리스트를 호출하는 코드 위의 코드는 제이슨만 보낸다.
			//ojbect 가 return 하는 result?? -> boardList 가 실행되고 그 값이 리턴된다. 즉 jsp의 뷰 이름이 리턴된다.
			
			return null;
//			return result;

		}
	}
}
