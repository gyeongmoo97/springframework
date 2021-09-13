package com.mycompany.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.webapp.dto.Ch08InputForm;

@Controller
@RequestMapping("/ch08")
@SessionAttributes({"inputForm"})
public class Ch08Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "/ch08/content";
	}
	
	//요청을 AJAX에서 한다고 가정
	@GetMapping(value= "/saveData", produces="application/json; charset=UTF-8")
	@ResponseBody
	//HttpSession session ==  HttpServletRequest request.getSession();
	public String saveData(String name, HttpServletRequest request) {
		logger.info("실행");
		logger.info("name" + name);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); // = {"result":"success"}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		return json;
	}
	
	//방법1
//	@GetMapping(value= "/readData", produces="application/json; charset=UTF-8")
//	@ResponseBody
//	//HttpSession session ==  HttpServletRequest request.getSession();
//	public String readData(HttpServletRequest request) {
//		logger.info("실행");
////		logger.info("name" + name);
//	
//		
//		 // = {"result":"success"}
//		HttpSession session = request.getSession();
//		
////		String name = session.getAttribute("name");
//		//가져올 때는 오브젝트로 가져와서 처음에는 오류가 생긴다
////		(방법1)
//		String name =(String) session.getAttribute("name");
//		logger.info("name"+name);
//		
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("name", name);
//		String json = jsonObject.toString();
//		
//		return json;
//	}
	
	
	//방법2 읽기만 하는건 void 로 만들어도 좋겠다.
	@GetMapping(value= "/readData", produces="application/json; charset=UTF-8")
	@ResponseBody
	//HttpSession session ==  HttpServletRequest request.getSession();
	public String readData(HttpServletRequest request, @SessionAttribute("name") String uname) {
		logger.info("실행");
//		logger.info("name" + name);
	
		
		 // = {"result":"success"}
		HttpSession session = request.getSession();
		
//		String name = session.getAttribute("name");
		//가져올 때는 오브젝트로 가져와서 처음에는 오류가 생긴다
//		(방법1)
//		String name =(String) session.getAttribute("name");
		logger.info("name"+uname);
		
//		(방법2)
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", uname);
		String json = jsonObject.toString();
		
		return json;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		logger.info("실행");
		return "ch08/loginForm";
	}
	
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession session) {
		logger.info("실행");
		if(mid.equals("spring") && mpassword.equals("12345")) {
			session.setAttribute("sessionMid", mid);
		}
		return "redirect:/ch08/content";
	}
	//ajax 요청에 대해서만 json, html 조각을 보낸다 그 외에는 뷰를 리턴한다/
	
	@GetMapping("/loginout")
	public String loginout(HttpSession session) {
		logger.info("실행");
		
		//방법1 직접 세션mid를 제거
		session.removeAttribute("sessionMid");
		//setAttribute 된 대상을 삭제
		
		//방법2 세션을 무효화 시키기 세션 객체를 삭제한다. 세션과 세션안의 모든데이터 날아감
//		session.invalidate();
		return "redirect:/ch08/content";

	}
	@PostMapping(value="/loginAjax", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String loginAjax(String mid, String mpassword, HttpSession session) {
		logger.info("실행");
		String result = "";
		
		if(!mid.equals("spring")) {
			result = "wrongMid";
		}else if(!mpassword.equals("12345")) {
			result = "wrongMpassword";
		}else {
			result = "success";
			session.setAttribute("sessionMid", mid);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		String json = obj.toString();
		return json;
	}
	/*내코드
	 	@PostMapping(value = "/loginAjax", produces = "application/json; charset=UTF-8")
		@ResponseBody
		public String loginAjax(String mid, String mpassword, HttpSession session) {
			logger.info("실행");
			String result = "";
			
			if(!mid.equals("spring")) {
				result= "wrongMid";
			} else if(!mpassword.equals("12345")) {
				result= "wrongMpassword";
			}else {
				result ="success";
				session.setAttribute("sessionMid", mid);
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", result);
			String json = jsonObject.toString();
			
			return json;
		}*/
	
	/*@GetMapping(value="/logoutAjax", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String logoutAjax(HttpSession session) {
		logger.info("실행");
		
		session.invalidate();
		
		JSONObject obj = new JSONObject();
		obj.put("result", "success");
		String json = obj.toString();
		return json;
	}*/
	
	/*	@GetMapping(value="/logoutAjax")
		
		public void logoutAjax(HttpSession session, HttpServletResponse response) throws IOException {
			logger.info("실행");
			
			session.invalidate();
	//		session.removeAttribute("sessionMid");
			response.setContentType("application/json; charset-UTF-8");
			PrintWriter pw = response.getWriter();
			
			
			
			JSONObject obj = new JSONObject();
			obj.put("result", "success");
			String json = obj.toString();
			
			pw.println(json);
	//		pw.flush();
	//		pw.close();
		}
		*/
@GetMapping(value="/logoutAjax")
	
	public void logoutAjax2(HttpSession session, HttpServletResponse response) throws IOException {
		logger.info("실행");
		
//		session.invalidate();
		session.removeAttribute("sessionMid");
		response.setContentType("application/json; charset-UTF-8");
		PrintWriter pw = response.getWriter();
		
		
		
		JSONObject obj = new JSONObject();
		obj.put("result", "success");
		String json = obj.toString();
		
		pw.println(json);
//		pw.flush();
//		pw.close();
	}
	
	
	
	
	
	
	//1단계2단계가 동시에 사용할 수 있도록 만들어 준다.
	@ModelAttribute("inputForm")
	// 원래 request 범위에 선언되어서 같은 컨트롤러 모든 메서드의 시작전에 실행되었는데
	// 이제는 단 한번 inputForm 이름이 존재하지 않을 경우 실행함.
	//@SessionAttributes({"inputForm"})가 추가되어 있을 경우
	// 컨트롤러의 메서드 수행마다 나타나나지 않게 된것이다.
	public Ch08InputForm getInputForm() {
		Ch08InputForm inputForm = new Ch08InputForm();
		return inputForm;
	}
	
// 지금 상태에서는 	Ch08InputForm inputForm 가 모두 다르다. 각자 새로 생성한 객체를
//	사용하고 서로 통하지 않는다.
//	@GetMapping("/inputStep1")
//	public String inputStep1(Ch08InputForm inputForm) {
//		logger.info("실행");
//		
//		return "ch08/inputStep1";
//	}
//
//	@PostMapping("/inputStep2")
//	public String inputStep2(Ch08InputForm inputForm) {
//		logger.info("실행");
//		
//		return "ch08/inputStep2";
//	}
//	@PostMapping("/inputDone")
//	public String inputDone(Ch08InputForm inputForm) {
//		logger.info("실행");
//		
//		return "redirect:/ch08/content";
//	}
	
	
	@GetMapping("/inputStep1")
	public String inputStep1(@ModelAttribute("inputForm") Ch08InputForm inputForm) {
		logger.info("실행");

		return "ch08/inputStep1";
	}
	
	@PostMapping("/inputStep2")
	public String inputStep2(@ModelAttribute("inputForm") Ch08InputForm inputForm) {
		logger.info("실행");
		logger.info("data1"+ inputForm.getData1());
		logger.info("data2"+ inputForm.getData2());
		logger.info("data3"+ inputForm.getData3());
		logger.info("data4"+ inputForm.getData4());
//		logger.info("data5"+ inputForm.getData5());
		
		return "ch08/inputStep2";
	}
	@PostMapping("/inputDone")
	public String inputDone( @ModelAttribute("inputForm") Ch08InputForm inputForm, SessionStatus session) {
		logger.info("실행");
		logger.info("data1"+ inputForm.getData1());
		logger.info("data2"+ inputForm.getData2());
		logger.info("data3"+ inputForm.getData3());
		logger.info("data4"+ inputForm.getData4());
		
		//세션에 저장되어있는 inputForm 제거
		session.setComplete();
		return "redirect:/ch08/content";
	}
	
}
