package com.mycompany.webapp.controller;

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
@RequestMapping("/ch17")
public class Ch17Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);
	
	@RequestMapping("/content")
	public String content() {
	
		return "ch17/content";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {	
		
		return "ch17/loginForm";
	}
	
}
