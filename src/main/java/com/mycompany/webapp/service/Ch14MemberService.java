package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.controller.Ch14Controller;
import com.mycompany.webapp.dao.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Member;

//관리객체로 만들면 자동주입된다.
@Service
public class Ch14MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberService.class);
	
	// 열거타입을 선언함
	public enum JoinResult {
		SUCCESS, FAIl, DUPLICATED
	}
	
	public enum LoginReslut{
		SUCCESS, FAIl, WRONG_ID, WRONG_PW
	}
	// enum 사용하지 않고 상수를 선언 할 수 도 있다.
//	public static final int JOIN_SUCCESS =0;
//	public static final int JOIN_FAIL=1;
//	public static final int JOIN_DUPLICATED=2;

	@Resource
	private Ch14MemberDao memberDao;

	// 회원 가입을 처리하는 비즈니스 메소드(로직)
//	컨트롤러에서 데이터를 받아와서 뭘하지?
	public JoinResult join(Ch14Member member) {
		// 이미 가입된 아이디인지 확인
		try {
			// SELECT * FROM memeber WHERE mid = ?
			// 참고로 mid 는 PK로 2개 이상 불러와 질 경우 없다.
			//DAO의 에러는 런타임에러 라서 에러가 Dao의 메서드를 호출한 서비스에서 발생한다. 서비스의 에러는 CATCH 에서 잡힌다.
			Ch14Member dbMember = memberDao.selectByMid(member.getMid());

			// DB에 회원 정보를 저장
			if (dbMember == null) {
				//DAO의 에러는 런타임에러 라서 에러가 Dao의 메서드를 호출한 서비스에서 발생한다. 서비스의 에러는 CATCH 에서 잡힌다.
				memberDao.insert(member);
				return JoinResult.SUCCESS;

			} else {
				return JoinResult.DUPLICATED;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JoinResult.FAIl;
		}

	}

	public LoginReslut login(Ch14Member member) {
		
		try {
			
			Ch14Member dbMember = memberDao.selectByMid(member.getMid());

			// DB에 회원 정보를 저장
			if (dbMember == null) {
				return LoginReslut.WRONG_ID;
			} else if(dbMember.getMpassword()==member.getMpassword()){
				return LoginReslut.SUCCESS;
			}else {
				return LoginReslut.WRONG_PW;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return LoginReslut.FAIl;
		}
	}
}
