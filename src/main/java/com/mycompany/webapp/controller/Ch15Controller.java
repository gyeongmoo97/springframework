package com.mycompany.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.Ch14BoardService;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.LoginReslut;

@Controller
@RequestMapping("/ch15")
public class Ch15Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch15Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "/ch15/content";
	}
	
	@RequestMapping("/before")
	public String beforeXXX() {
		logger.info("실행");
		return "redirect:/ch15/content";
	}
	
	@RequestMapping("/after")
	public String afterXXX() {
		logger.info("실행");
		return "redirect:/ch15/content";
	}
	@RequestMapping("/afterReturning")
	public String afterReturning() {
		logger.info("실행");
		return "redirect:/ch15/content";
	}
	
	@RequestMapping("/afterThrowing")
	public String afterThrowing() {
		logger.info("실행");
		if(true) {
			throw new RuntimeException("테스트 예외입니다.");
		}
		return "redirect:/ch15/content";
	}
	@RequestMapping("/around")
	public String around() {
		logger.info("실행");
	
		return "redirect:/ch15/content";
	}
	
	
	@Resource
	private Ch14BoardService ch14BoardService;
	
	@RequestMapping("/runtimeCheck")
	public String runtimeCheck() {
		logger.info("실행");
		Pager pager = new Pager(10, 5, ch14BoardService.getTotalBoardNum(), 1);
		List<Ch14Board> boards = ch14BoardService.getBoards(pager);
		return "redirect:/ch15/content";
	}
	
	
	@RequestMapping("/authCheck")
	public String authCheck() {
		logger.info("실행");
		
		return "redirect:/ch15/content";
	}
	

	
	@GetMapping("/login")
	public String loningForm() {
		logger.info("실행");
		return "ch15/loginForm";
	}
	
	@Resource 
	private Ch14MemberService memberService;
	
	
	@PostMapping("/login")
	public String loning(Ch14Member member, Model model, HttpSession session) {
		logger.info("실행");
		LoginReslut result = memberService.login(member);
		if(result == LoginReslut.SUCCESS) {
			
			//login 성공하면 session 에 id 저장
			session.setAttribute("sessionMid", member.getMid());

			return "redirect:/ch15/content";
		} else if(result == LoginReslut.WRONG_ID) {
			String error= "아이디가 존재하지 않습니다";
			model.addAttribute("error", error);
			return "ch15/loginForm";
		}else if(result == LoginReslut.WRONG_PW) {
			String error= "비밀번호가 일치하지 않습니다";
			model.addAttribute("error", error);
			return "ch15/loginForm";
		}else {
			String error= "잘못된 입력 혹은, 서버 오류로 인하여 로그인이 실패하였습니다.";
			model.addAttribute("error", error);
			return "ch15/loginForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("실행");
		session.removeAttribute("sessionMid");

		return "redirect:/ch15/content";
	}
	
	@GetMapping("/boardList1")
	public String boardList1(Model model) {
		logger.info("실행");
		Pager pager = new Pager(5, 5, ch14BoardService.getTotalBoardNum(), 1);
		List<Ch14Board> boards = ch14BoardService.getBoards(pager);
		model.addAttribute("boards", boards);
		return "ch15/boardList";
	}
//	
//	@GetMapping("/boardList")
//	public void boardList(Model model) {
//		logger.info("실행");
//		Pager pager = new Pager(5, 5, ch14BoardService.getTotalBoardNum(), 1);
//		List<Ch14Board> boards = ch14BoardService.getBoards(pager);
//		model.addAttribute("boards", boards);
////		return "ch15/boardList";
//	}
//	
	
	@GetMapping(value="/boardList2", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String boardList2(Model model) {
		logger.info("실행");
		Pager pager = new Pager(5, 5, ch14BoardService.getTotalBoardNum(), 1);
		List<Ch14Board> boards = ch14BoardService.getBoards(pager);
//		model.addAttribute("boards", boards);
	
		
		
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		JSONArray jsonArray = new JSONArray();
		for(Ch14Board board : boards) {
			JSONObject boardObject = new JSONObject();
			boardObject.put("bno", board.getBno());
			boardObject.put("btitle", board.getBtitle());
			boardObject.put("bdate", sdf.format(board.getBdate()));
			// 날짜를 원햐는 양식의 문자열 형태로 반환
			boardObject.put("mid", board.getMid());
			jsonArray.put(boardObject);
		}
		
		
		jo.put("boards", boards);
		String json = jo.toString();
		
		return json;
	}
	
	
}
