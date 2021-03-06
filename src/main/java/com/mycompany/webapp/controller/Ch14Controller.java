package com.mycompany.webapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.Ch14BoardService;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.JoinResult;
import com.mycompany.webapp.service.Ch14MemberService.LoginReslut;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch14Controller.class);

	// bean 에 있는 dataSource 를 Ch14cotroller 에 DI
	@Resource
	private DataSource dataSource;

	@RequestMapping("/content")
	public String content() {

		return "ch14/content";
	}

	@GetMapping("/testConnectToDB")
	public String testConnectToDB() throws SQLException {

		Connection conn = dataSource.getConnection();
		logger.info(" 연결 성공 ");

		// 연결 객체 반납하기 close 는 닫는게 아닌 connection pool로 반납하여 가용한 상태로 남는것이다.
		conn.close();
		return "redirect:/ch14/content";
	}

//jdbc api 사용해보기
	@GetMapping("/testInsert")
	public String testInsert() throws SQLException {
		// 커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		logger.info(" 연결 성공 ");
		// 작업처리
//		 String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, '제목1', '내용1', SYSDATE, 'user')";
		try {
			String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, ?, ?, SYSDATE, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 월요일");
			pstmt.setString(2, "즐거운 시작");
			pstmt.setString(3, "user");
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 연결 객체 반납하기 close 는 닫는게 아닌 connection pool로 반납하여 가용한 상태로 남는것이다.
		conn.close();
		return "redirect:/ch14/content";
	}

	@GetMapping("/testSelect")
	public String testSelect() throws SQLException {
		// 커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		logger.info(" 연결 성공 ");
		// 작업처리
//		 String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, '제목1', '내용1', SYSDATE, 'user')";
		try {
			String sql = "SELECT bno, btitle, bcontent, bdate, mid FROM board";
			// SQL을 전달
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				String mid = rs.getString("mid");
				logger.info(bno + "\t" + btitle + "\t" + bcontent + "\t" + bdate + "\t" + mid);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 연결 객체 반납하기 close 는 닫는게 아닌 connection pool로 반납하여 가용한 상태로 남는것이다.
		conn.close();
		return "redirect:/ch14/content";
	}

	@GetMapping("/testUpdate")
	public String testUpdate() throws SQLException {
		// 커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		logger.info(" 연결 성공 ");
		// 작업처리
//		 String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, '제목1', '내용1', SYSDATE, 'user')";
		try {
			String sql = "UPDATE board SET btitle=?, bcontent=? WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "배가 고프네요");
			pstmt.setString(2, "점심 먹으러 안제갈까요?");
			// int 값을 set 하는것이면 setInt 써야한다.
			pstmt.setInt(3, 1);
			// select 빼고는 다 update 사용
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 연결 객체 반납하기 close 는 닫는게 아닌 connection pool로 반납하여 가용한 상태로 남는것이다.
		conn.close();
		return "redirect:/ch14/content";
	}

	@GetMapping("/testDelete")
	public String testDelete() throws SQLException {
		// 커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		logger.info(" 연결 성공 ");
		// 작업처리
//		 String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, '제목1', '내용1', SYSDATE, 'user')";
		try {
			String sql = "DELETE FROM board WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// int 값을 set 하는것이면 setInt 써야한다.
			pstmt.setInt(1, 0);
			// select 빼고는 다 update 사용
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 연결 객체 반납하기 close 는 닫는게 아닌 connection pool로 반납하여 가용한 상태로 남는것이다.
		conn.close();
		return "redirect:/ch14/content";
	}

	@Resource
	private Ch14MemberService memberService;

	@GetMapping("/join")
	public String joinForm() {
		return "ch14/joinForm";
	}

	@PostMapping("/join")
	public String join(Ch14Member member, Model model) {
		// 유효성 검사 @Valid
		// 필요한 데이터 서버에서 보충 (데이터 가공)
		member.setMenabled(1);
		member.setMrole("ROLE_USER");
		// 서비스에 객체를 넘겨줌으로서 원래 하려던 회원가입기능 처리
//		서비스로 이동
		JoinResult jr = memberService.join(member);
		if (jr == JoinResult.SUCCESS) {
			return "redirect:/ch14/content";
		} else if (jr == JoinResult.DUPLICATED) {
			model.addAttribute("error", "중복된 아이디를 입력했습니다.");
			return "/ch14/joinForm";
		} else {
			model.addAttribute("error", "회원 가입이 실패되었습니다. 다시 시도해 주세요.");
			return "/ch14/joinForm";
		}
	}

	@GetMapping("/login")
	public String loginForm() {
		return "ch14/loginForm";
	}

	@PostMapping("/login")
	public String login(Ch14Member member, Model model) {
		LoginReslut reslut = memberService.login(member);
		if (reslut == LoginReslut.SUCCESS) {

			return "redirect:/ch14/content";
		} else if (reslut == LoginReslut.WRONG_ID) {
			model.addAttribute("error", "아이디가 틀렸으니 다시 입력하세요");
			return "/ch14/loginForm";
		} else if (reslut == LoginReslut.WRONG_PW) {
			model.addAttribute("error", "아이디에 맞는 비밀번호를 다시 입력하세요");
			return "/ch14/loginForm";
		} else {
			model.addAttribute("error", "죄송합니다. 오류가 발생했습니다. 다시 시도해주세요");
			return "/ch14/loginForm";
		}

	}

	@Resource
	private Ch14BoardService boardService;

	@GetMapping("/boardList")
	public String boardList(@RequestParam(defaultValue ="1") int pageNo, Model model) {
		
		int totalRows = boardService.getTotalBoardNum();
		Pager pager = new Pager(10, 5, totalRows, pageNo);
		model.addAttribute("pager",pager);
		
		List<Ch14Board> boards = boardService.getBoards(pager);
		model.addAttribute("boards", boards);
		return "ch14/boardList";
	}

	@GetMapping("/boardWriteForm")
	public String boardWriteForm() {
		return "ch14/boardWriteForm";
	}

	@PostMapping("/boardWrite")
	public String boardWrite(Ch14Board board) {
		boardService.writeBoard(board);
		return "redirect:/ch14/boardList";
	}

	@GetMapping("/detailBoard")
	public String detailBoard(int bno, Model model) {
		Ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardDetail";
	}

	@GetMapping("/boardUpdateForm")
	public String boardUpdateForm(int bno, Model model) {
		Ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardUpdateForm";
	}

	@PostMapping("/boardUpdate")
	public String boardUpdate(Ch14Board board) {
		boardService.updateBoard(board);
		return "redirect:/ch14/boardDetail?bno=" + board.getBno();
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(int bno, Model model) {
		Ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardDetail";
	}

	@GetMapping("/boardDelete")
	public String boardDelete(int bno) {
		boardService.removeBoard(bno);
		return "redirect:/ch14/boardList";
	}
}
