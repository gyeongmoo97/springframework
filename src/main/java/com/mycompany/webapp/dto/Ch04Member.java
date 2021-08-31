package com.mycompany.webapp.dto;

public class Ch04Member {
	private String mid;
	private String mpassword;
	private String memail;
	private String mtel;
	// 이름은 input으로 받는 파라미터의 name속성과 같아야한다
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
}
