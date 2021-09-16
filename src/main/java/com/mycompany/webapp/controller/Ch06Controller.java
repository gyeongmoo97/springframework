package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@RequestMapping("/forward")
	public String forward() {
		return "ch06/forward";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
		@GetMapping("/getFragmentHtml")
		public String getFragmentHtml() {
			logger.info("실행");
			return "ch06/fragmentHtml";
		}
	
	@GetMapping("/getJson1")
	public void getJson(HttpServletResponse response) throws Exception {
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo5.jpg");
		String json = jsonObject.toString();
		//헤더에 바디에 들어갈 정보를 미리 넣어준 부분
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value="/getJson2", produces="application/json; charset=UTF-8")
	@ResponseBody
	//리턴되는 값을 response body 에 넣으라는 의미
	public String getJson2()  {
		
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo7.jpg");
		String json = jsonObject.toString();
		return json;
	}
	//return 되면 그 내용은 응답바디에 들어간 내용이며 응답바디에 값을 넣고나서는 응답 헤더에 값을 꼭 넣어줘야함.
	
	@GetMapping("/getJson3")
	//리턴되는 값을 response body 에 넣으라는 의미
	public String getJson3()  {
		
		logger.info("실행");
	
//		return "redirect:/";
		return "redirect:/ch06/getJson2";
	}
	//ajax는 json을 받으려고 하는건데 다른 주소로 보내보리는 것
	//ajax의 목적은 json 을 받는것인데 서버에서 다른 주소로 연결하는 리다이렉트를 해서는 안된다.
	
}



//package com.mycompany.webapp.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/ch06")
//public class Ch06Controller {
//	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
//
//	//초기화 확인 
//	public Ch06Controller() {
//		logger.info("실행");
//	}
//	
//	@RequestMapping("/content")
//	public String content() {
//		return "ch06/content";
//	}
//	
//	@RequestMapping("/forward")
//	public String forward() {
//		return "ch06/forward";
//	}
//	@RequestMapping("/redirect")
//	public String redirect() {
//		return "redirect:/";
//	}
//	@RequestMapping("/ajax1")
//	public String ajax1() {
//		return "ch06/content";
//	}
////	@RequestMapping("/ajax2")
////	public String ajax2() {
////		return "ch06/content";
////	}
//	@RequestMapping("/getFragmentHtml")
//	public String getFragmentHtml() {
//		logger.info("실행");
//		return "ch06/content";
//	}
//	@RequestMapping("/getJson")
//	public void getJson(HttpServletResponse response) throws Exception {
//		logger.info("실행");
//		JSONObject jo = new JSONObject();
//		jo.put("fileName", "photo5.jpg");
//		String json = jo.toString();
//		
//		//html 보낼때는 MIME타입을 application으로 지정해야함
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.println(json);
//		pw.flush();
//		pw.close();
////		return "ch06/content";
//	}
//	
//}
