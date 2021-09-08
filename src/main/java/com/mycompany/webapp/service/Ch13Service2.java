package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao1;
import com.mycompany.webapp.dao.Ch13BoardDao2;

@Service
public class Ch13Service2 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service2.class);

//	@Autowired
	@Resource
	private Ch13BoardDao2 ch13BoardDao2;

	// setter 주입을 위한 Setter 선언
//	@Autowired
//	public void setCh13BoardDao2(Ch13BoardDao2 ch13BoardDao2) {
//		logger.info(" setCh13BoardDao2 실행  ");
//		this.ch13BoardDao2 = ch13BoardDao2;
//	}

	public Ch13Service2() {
		logger.info("실행");
	}
	
	public void method2() {
		logger.info(" method2()실행");
		ch13BoardDao2.update();
	}
}
