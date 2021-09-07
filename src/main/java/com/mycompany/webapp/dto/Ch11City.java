package com.mycompany.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Ch11City {
	private int code;
	private String label;
	
	public Ch11City(int code, String label) {
		super();
		this.code = code;
		this.label = label;
	}
	public Ch11City() {
		super();
	}
	
}
