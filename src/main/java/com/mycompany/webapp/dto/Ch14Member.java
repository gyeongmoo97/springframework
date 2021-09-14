package com.mycompany.webapp.dto;

import org.springframework.stereotype.Repository;

import lombok.Data;


@Data
public class Ch14Member {
	private String mid;
	private String mname;
	private String mpassword;
	private int menabled;
	private String mrole;
}
