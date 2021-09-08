package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao1;


public class Ch13Service1 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service1.class);
	
	private Ch13BoardDao1 ch13BoardDao1;
	
	public Ch13Service1() {
		logger.info(" Ch13Service1()실행");
	}
	// 생성자 주입을 위한 생성자 선언
	public Ch13Service1(Ch13BoardDao1 ch13BoardDao1) {
		this.ch13BoardDao1=ch13BoardDao1;
		logger.info("Ch13Service1(Ch13BoardDao1 ch13BoardDao1)실행");
	}
	
	//setter 주입을 위한 Setter 선언
	public void setCh13BoardDao1( Ch13BoardDao1 ch13BoardDao1 ) {
		logger.info(" setCh13BoardDao1 실행  ");
		this.ch13BoardDao1 = ch13BoardDao1;
	}
	
	//INFO : com.mycompany.webapp.service.Ch13Service1.<init>() - Ch13Service1(Ch13BoardDao1 ch13BoardDao1)실행
	//	INFO : com.mycompany.webapp.service.Ch13Service1.setCh13BoardDao1() -  setCh13BoardDao1 실행  
	//따로 생성자 만들어주면 그 생성자를 통해서 객체를 초기화, setter가 있으면 초기화 하면서 DI 가능
	//어노테이션 방식은 무조건 기본생성자를 활용해서 객체를 초기화 하기에 생성자 DI 불가능
	
	public void method1() {
		logger.info(" method1()실행");
		ch13BoardDao1.update();
	}
}
