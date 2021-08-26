package com.mycompany.webapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ch01")
public class Ch02Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행1 " );
		logger.warn("실행2");
		logger.debug("실행3 ");
		logger.error("실행4");
		return "ch01/content";
	}
	
	
	@RequestMapping("/login")
	public String login() {
		logger.info("실행");
		
		return "ch01/login";
	}
}
