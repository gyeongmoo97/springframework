package com.mycompany.webapp.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch07City;
import com.mycompany.webapp.dto.Ch07Cloth;
import com.mycompany.webapp.dto.Ch07Member;

@Controller
@RequestMapping("/ch07")
public class Ch07Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch07Controller.class);

	@RequestMapping("/content")
	public String content() {

		return "ch07/content";
	}

	@GetMapping("/saveDate")
	public String saveData(HttpServletRequest request) {
		// Request 범위에 데이터를 저장
		logger.info("실행");
		request.setAttribute("requestData", "자바");
	
		HttpSession session = request.getSession();
		// 같은 요청안에서는 데이터가 유지됨.
		session.setAttribute("sessionData", "자바스크립트");
		// 같은 브라우저 범위에서는 데이터가 유지됨

		// 서블릿이 실행되는 환경의 객체? 웹애플리케이션 전체에 대한 객체?
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationData", "백-엔드 스프링프레임워크");
		
		return "ch07/readData";
	}

	@GetMapping("/readDate")
	public String readData() {
		logger.info("실행");
		return "ch07/readData";
	}

	@GetMapping("objectSaveAndRead1")
	public String objectSaveAndRead1(HttpServletRequest request) {
		logger.info("실행");

		Ch07Member member = new Ch07Member();
		member.setName("홍길동");
		member.setAge(25);
		member.setJob("dev");
		Ch07City city = new Ch07City();
		city.setName("서울역");
		member.setCity(city);

		// request 에 문자열 뿐 아니라 객체도 담을 수 있다.
		request.setAttribute("member", member);

		return "ch07/objectRead";
	}

	// ModelAndView 는 현대에서 사용하는 방식
	@GetMapping("objectSaveAndRead2")
	public ModelAndView objectSaveAndRead2() {
		logger.info("실행");

		Ch07Member member = new Ch07Member();
		member.setName("홍길동2");
		member.setAge(25);
		member.setJob("dev");
		Ch07City city = new Ch07City();
		city.setName("서울태릉");
		member.setCity(city);

		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member); // request 범위에 저장함 어디에 request 범위라고 명시해두지는 않음
		mav.setViewName("ch07/objectRead");

		return mav;
	}

	@GetMapping("objectSaveAndRead3")
	public String objectSaveAndRead3(Model model) {
		logger.info("실행");

		Ch07Member member = new Ch07Member();
		member.setName("홍길동3");
		member.setAge(25);
		member.setJob("dev");
		Ch07City city = new Ch07City();
		city.setName("서울공릉");
		member.setCity(city);

		model.addAttribute("member", member); // request 범위에 저장함 어디에 request 범위라고 명시해두지는 않음
		// 만약 여러 객체 보내고 싶으면 addAttribute 를 여러번 하면 된다.

		return "ch07/objectRead";
	}

	// jstl
	@GetMapping("useJstl1")
	public String useJstl1(Model model) {
		logger.info("실행");
		
		String[] languages= {"java","javascript", "springframework", "vue" };
		model.addAttribute("langs", languages);
		 
		return "ch07/useJstl1";
	}
	
	
	@GetMapping("useJstl2")
	public String useJstl2(Model model) {
		logger.info("실행");
		java.util.List<Ch07Board> list = new ArrayList();
		for (int i = 0; i < 5; i++) {
			list.add(new Ch07Board(i, "제목"+i, "내용"+i,"글쓴이"+i, new Date()));
		}
		
		model.addAttribute("boardList", list);
		//request 범위에 있는 list 이다.
		
		return "ch07/useJstl2";
	}
	
	@ModelAttribute("colors") //model.addAttribute 이름이 거의 똑같음, 효과도 같음
	//request 범위에 colors 라고 저장함
	public String[] getColors() {
		logger.info("실행");
		String[] colors= {"Red", "Green", "Blue", "Mint", "Yellow"};
		return colors;
	}
	
	// request 범위에서 저장된다.
	// 하지만 공통데이터로서 해당 값을 같은 컨트롤러의 메서드에서 연결된 모든 JSP에서 쓸 수 있다. 
	//그 이유는 모든 요청이 있을 때 마다 실행되기 때문이다.
	
	
	
//	@GetMapping("useModelAttribute1")
//	public String useModelAttribute1(Model model) {
//		logger.info("실행");
//		
//		String[] colors= {"Red", "Green", "Blue", "Mint", "Yellow"};
//		model.addAttribute("colors", colors);
//		
//		return "ch07/useModelAttribute";
//	}

	
	@GetMapping("useModelAttribute1")
	public String useModelAttribute1() {
		logger.info("실행");
		
		
		
		return "ch07/useModelAttribute";
	}
	
	@GetMapping("useModelAttribute2")
	public String useModelAttribute2() {
		logger.info("실행");
		
	
		
		return "ch07/useModelAttribute";
	}
	@GetMapping("/argumentSaveAndRead1")
	public String argumentSaveAndRead1(String kind, String sex, Model model) {
		logger.info("실행");
		
		logger.info("kind :"+kind);
		logger.info("sex :"+sex);
		
		model.addAttribute("kind", kind);
		model.addAttribute("sex", sex);
		return "ch07/argumentRead";
	}
	
	@GetMapping("/argumentSaveAndRead2")
	//(@ModelAttribute("key") String value) key- val 형식으로 저장함
	public String argumentSaveAndRead2(@ModelAttribute("kind") String kind, @ModelAttribute("sex") String sex) {
		logger.info("실행");		
		logger.info("kind :"+kind);
		logger.info("sex :"+sex);
		return "ch07/argumentRead";
	}

	@GetMapping("/argumentSaveAndRead3")
	//(@ModelAttribute("key") String value) key- val 형식으로 저장함
	// 클래스 첫글짜 소문자로 관리된다고 했던거 -> requset 범위에서 관리함
	//개별적으로 받는 매개변수는 자동 관리아 안됨. 하지만 객체는 첫글자를 소문자로한 이름으로 자동으로 request 범위로 저장됨.
	public String argumentSaveAndRead3(@ModelAttribute("cloth") Ch07Cloth cloth) {
		logger.info("실행");
		
		logger.info("kind :"+cloth.getKind());
		logger.info("sex :"+cloth.getSex());
		
		
		return "ch07/argumentRead2";
	}
	
}
