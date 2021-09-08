package com.mycompany.webapp.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch11City;
import com.mycompany.webapp.dto.Ch11Member;
import com.mycompany.webapp.dto.Ch11Skill;


@ControllerAdvice
@RequestMapping("/ch11")
public class Ch11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch11Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		
		return "/ch11/content";
	}
	
//	@GetMapping("/form1")
//	public String form1(Model model) {
//		logger.info("실행");
//		String defultNation = "한국";
//		model.addAttribute("defultNation", defultNation);
//		// 모델에 넣어서 값을 보내주면 form 에서 값을 사용가능하다
////		value="${defultNation}"
//		// 하지만 이 방식은 값을 넘겨줘서 사용하는것이고 dto와 form을 연동한 것은 아니다
//		
//		return "ch11/form1";
//	}
	
	// arg로 받은 객체는 스프링에서 앞글자를 소문자로 만든 이름으로 관리한다.
	// 스프링에서 관리하는 값은 EL로 표시할 수 있기때문에
	//${ch11Member.mnation}
//	@ModelAttribute 로 스프링컨테이너가 기본적으로 관리하는 객체명을 변환할 수 있따.
	// 초기값을 설정해주기 위해서 사용함
	@GetMapping("/form1")
	public String form1(@ModelAttribute ("member") Ch11Member member) {
		logger.info("실행");		
		member.setMnation("미국");
		
		return "ch11/form1";
	}
	
	//form 태그의 값을 받아오기위해사용
	@PostMapping("/form1")
	public String handleForm1(@ModelAttribute ("member") Ch11Member member) {
		logger.info("실행");
		
		logger.info("Mid" +member.getMid());
		logger.info("Mname" +member.getMname());
		logger.info("Mnation" +member.getMnation());
		logger.info("Mpassword" +member.getMpassword());
		return "redirect:/ch11/content";
	}
	
	//form 태그의 값을 받아오기위해사용
	@GetMapping("/form2")
	public String handleForm2(@ModelAttribute ("member") Ch11Member member, Model model) {
		logger.info("실행");
		java.util.List<String> typeList = new ArrayList<>();
		// 아래의 값은 DB에서 가져왔다고 가정한 값
		// 드롭다운 리스트의 항목을 제공하기 위한 값
		typeList.add("일반회원");
		typeList.add("기업회원");
		typeList.add("헤드헌터회원");
		model.addAttribute("typeList", typeList);
		
		//기본 선택 항목을 설정
		member.setMtype("기업회원");
		
		
		
		//드롭다운리스트 항묵을 추가할 목적으로 리스트 추가
		java.util.List<String> jobList = new ArrayList<String>();
		jobList.add("학생");
		jobList.add("개발자");
		jobList.add("디자이너");
		
		model.addAttribute("jobList", jobList);
		
		//member.mjob 이것이 기본값이 됨
		member.setMjob("개발자");
		
		
		//드롭다운의 항목을 생성하기 위함
		java.util.List<Ch11City> cityList = new ArrayList<Ch11City>();
		cityList.add(new Ch11City(1,"서울"));
		cityList.add(new Ch11City(2,"부산"));
		cityList.add(new Ch11City(3,"제주"));
		model.addAttribute("cityList", cityList);
		
		
		//기본 선택 항목을 설정
		member.setMcity(2);
		
		return "ch11/form2";
	}
	
	@PostMapping("/form2")
	public String handleForm2(@ModelAttribute ("member") Ch11Member member) {
		logger.info("실행");
		logger.info("getMtype"+member.getMtype());
		logger.info("mgetMjob"+member.getMjob());
		logger.info("mgetMcitys"+member.getMcity());
	
		return "redirect:/ch11/content";
	}
	
	@GetMapping("/form3")
	public String handleForm3(@ModelAttribute("member") Ch11Member member, Model model) {
		logger.info("실행");
		
		java.util.List<String> languageList = new ArrayList<String>();
		
		//DB에서 받아온 값이라고 생각해야한다. DB에서 받아온 값이니 Model 에서 사용해야한다.
		languageList.add("C");
		languageList.add("Python");
		languageList.add("Java");
		languageList.add("JavaScript");
		
		model.addAttribute("languageList", languageList);
		
		member.setMlanguage(new String[] {"Python", "JavaScript"});
		
		java.util.List<Ch11Skill> skillList = new ArrayList<Ch11Skill>();
		skillList.add(new Ch11Skill(1,"SpringFramework"));
		skillList.add(new Ch11Skill(2,"SpringBoot"));
		skillList.add(new Ch11Skill(3,"Vue"));
		model.addAttribute("skillList", skillList);
		
		member.setMskill(new int[] {1});
		
		
		//일반HTML 태그로 작성 + 스프링 tag 사용하여 줄여서작성 2가지 방법으로 작성해볼 예정
		
		return "ch11/form3";
	}
	
	@PostMapping("/form3")
	public String handleForm3(@ModelAttribute("member") Ch11Member member) {
		logger.info("실행");
		
		if(member.getMlanguage() !=null) {
			for(String lang : member.getMlanguage()) {
				logger.info("lang: " + lang);
			}
		}
		
		System.out.println("mskill: " +Arrays.toString(member.getMskill()));
		return "redirect:/ch11/content";
	}
	
	@GetMapping("/form4")
	public String Form4(@ModelAttribute("member") Ch11Member member, Model model) {
		logger.info("실행");
		
		java.util.List<String> languageList = new ArrayList<String>();
		
		//드롭다운리스트 항묵을 추가할 목적으로 리스트 추가
		java.util.List<String> jobList = new ArrayList<String>();
		jobList.add("학생");
		jobList.add("개발자");
		jobList.add("디자이너");
		
		model.addAttribute("jobList", jobList);
		
		//member.mjob 이것이 기본값이 됨
		member.setMjob("개발자");
		
		
		//드롭다운의 항목을 생성하기 위함
		java.util.List<Ch11City> cityList = new ArrayList<Ch11City>();
		cityList.add(new Ch11City(1,"서울"));
		cityList.add(new Ch11City(2,"부산"));
		cityList.add(new Ch11City(3,"제주"));
		model.addAttribute("cityList", cityList);
		
		
		//기본 선택 항목을 설정
		member.setMcity(2);
		
		return "ch11/form4";
	}
	

	
	@PostMapping("/form4")
	public String handleForm4(@ModelAttribute("member") Ch11Member member) {
		logger.info("실행");
		
		logger.info("mjob" +member.getMjob());
//		System.out.println("mskill: " +Arrays.toString(member.getMskill()));
		return "redirect:/ch11/content";
	}
	
	@GetMapping("/form5")
	public String form5(@ModelAttribute("member") Ch11Member member){
		logger.info("실행");
		return "ch11/form5";
	}
	
}
