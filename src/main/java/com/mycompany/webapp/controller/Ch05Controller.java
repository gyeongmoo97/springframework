package com.mycompany.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/ch05")
public class Ch05Controller {

	private static final Logger loger = LoggerFactory.getLogger(Ch05Controller.class);

	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}

	@GetMapping("/getHeaderValue")
	public String getHeaderValue(HttpServletRequest request) {
		loger.info("실행");
		// HttpServletRequest request 요청에 대한 모든 정보 있다.
		loger.info("request method" + request.getMethod());
		// 요청방식 얻기
		loger.info("requestURI" + request.getRequestURI());
		// context root 이후 주소 얻기 //시작행에 있는 context 루트 이후 주소값을 반환
		loger.info("requestURL" + request.getRequestURL());
		// 전체 주소 얻기
		loger.info("request.getRemoteAddr() " + request.getRemoteAddr());
		// request.getRemoteAddr() 요청한 PC가 주소한 IP 주소특정한 사건이 일어났을 때 어느 IP에서 문제를 일으킨
//		것인지 알 수 있다.
		loger.info("request.getContextPath() " + request.getContextPath());
		// 컨텍스트 루트를 얻어낸다. / 인경우 아무것도 안나옴

		String userAgent = request.getHeader("User-Agent");
		loger.info("User-Agent " + userAgent);
		// 클라이언트의 브라우저 종류
//		loger.info("request.getContextPath() " +request.getContextPath());
//		//클라이언트가 사용하는 OS의 종류
		if (userAgent.contains("Windows NT")) {
			loger.info("클라이언트 OS : Windows");
		} else if (userAgent.contains("Macintosh")) {
			loger.info("클라이언트 OS : Mac");
		}

		if (userAgent.contains("Edg")) {
			loger.info("client browser : edge");
		} else if (userAgent.contains("Trident")) {
			loger.info("client browser : IE11");
		} else if (userAgent.contains("Chrome")) {
			loger.info("client browser : Chrome");
		} else if (userAgent.contains("Safari")) {
			loger.info("client browser : Safari");
		}
		return "redirect:/ch05/content";
	}

	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		loger.info("실행");

		// 쿠키생성
		Cookie cookie = new Cookie("useremail", "mwe226@naver.com");
		// 브라우저에게 쿠키 전달 => 쿠키를 리스폰스에 담아서 보내줌
//		cookie.setComment("192.168.1.8");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(30 * 60);// 초단위
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		response.addCookie(cookie);

		return "redirect:/ch05/content";
	}

	@GetMapping("/getCookie1")
	public String getCookie1(@CookieValue String useremail, @CookieValue("useremail") String uemail) {
		loger.info("실행");

		loger.info("uemail : " + uemail);
		loger.info("useremail : " + useremail);

		return "redirect:/ch05/content";
	}

	@GetMapping("/getCookie2")
	public String getCookie2(HttpServletRequest request) {
		loger.info("실행");
		// 배열로 쿠키를 리턴함
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			if (cookieName.equals("useremail")) {
				loger.info(cookieValue);
				break;
			}
		}
		return "redirect:/ch05/content";
	}

	@GetMapping("/createJsonCookie")
	public String createJsonCookie(HttpServletResponse response) throws Exception {
		loger.info("실행");

//		String json = "{\"userid\":\"fall\", \"useremail\":\"fall@company.com\", \"tell\":\"0101234567\"}";
		// 직접 json 타이핑 하는것 굉장히 번거롭고 보기 풀편하다.
		// json에서 {}는객체 []는 배열
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userid", "fall");
		jsonObject.put("useremail", "fall@company.com");
		jsonObject.put("usertel", "123456789");
		jsonObject.put("username", "홍길동");
		String json = jsonObject.toString();

		// String json = "{\"userid\":\"fall\", \"useremail\":\"fall@company.com\",
		// \"tell\":\"0101234567\"}";
		// 위의 내용과 같다.
		loger.info(json);
		json = URLEncoder.encode(json, "UTF-8");
		loger.info(json);

		Cookie cookie = new Cookie("user", json);
		response.addCookie(cookie);

		return "redirect:/ch05/content";
	}

	@GetMapping("/getJsonCookie")
	public String getJsonCookie(@CookieValue String user) {
		loger.info("실행");

		loger.info("user: " + user);
		JSONObject jsonObject = new JSONObject(user);
		// JSONObject 객체를 사용하면 json을 다시 객체로 만들어줌
		loger.info("userid : " + jsonObject.getString("userid"));
		loger.info("useremai : " + jsonObject.getString("useremail"));
		loger.info("usertel : " + jsonObject.getString("usertel"));
		loger.info("username : " + jsonObject.getString("username"));

		return "redirect:/ch05/content";
	}

	@GetMapping("/createJwtCookie")
	public String createJwtCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		loger.info("실행");

		String userid = "spring";
		String useremail = "fall@naver.com";
		String username = "홍흥길동동";

		JwtBuilder builder = Jwts.builder();
//		/HEADER: 부분설정
		builder.setHeaderParam("alg", "HS256");
		builder.setHeaderParam("typ", "JWT");
		// jwt 토큰도 항상유효한게 아니라 유효시간이 있어야한다.
		// new Date().getTime() -> 1970년 1월1일 기준 1000분의 1초 단위로 지금까지 카운트
		// (1000분의1초)1000*60*30 = 30분
		builder.setExpiration(new Date(new Date().getTime() + 1000 * 60 * 30));

		// PAYLOAD:, Claim 비슷한 표현임
		builder.claim("userid", userid);
		builder.claim("useremail", useremail);
		builder.claim("username", username);

		// VERIFY SIGNATURE 서명
		String secretKey = "abc12345";
		// 비밀키는 코드에 직접 입력하기 보다는 properties 에 저장하는게 좋다.
		// 비밀키는 바이트형태로 보내고 인코딩 거쳐서 넣어준다.
		builder.signWith(SignatureAlgorithm.HS256, secretKey.getBytes("UTF-8"));
		String jwt = builder.compact();
		loger.info("jwt : " + jwt);

		Cookie cookie = new Cookie("jwt", jwt);
		response.addCookie(cookie);

		return "redirect:/ch05/content";
	}

	@GetMapping("/getJwtCookie")
	public String getJwtCookie(@CookieValue String jwt) throws UnsupportedEncodingException {
		loger.info("실행");
		loger.info("jwt 복호화 전" + jwt);
		// 복호화 과정 시작
		String secretKey = "abc12345";
		// Jwtparser객체 생성
		JwtParser parser = Jwts.parser();
		parser.setSigningKey(secretKey.getBytes("UTF-8"));
		Jws<Claims> jws = parser.parseClaimsJws(jwt);
		Claims claims = jws.getBody();
		String userid = claims.get("userid", String.class);
		String useremail = claims.get("useremail", String.class);
		String username = claims.get("username", String.class);
		
		loger.info("userid : " + userid);
		loger.info("useremai : " +useremail);
		loger.info("username : " + username);

		return "redirect:/ch05/content";
	}

}
