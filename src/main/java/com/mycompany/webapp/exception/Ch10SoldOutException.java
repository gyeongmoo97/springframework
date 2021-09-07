package com.mycompany.webapp.exception;

//일반예외로 만들면 try catch를 요구하기 때문에 실행예외로 만들어야한다.
//실행예외 runttime exception 을 상속받아야 try catch 를 요구하지 않고 그래서 
// 메서드에서 try catch를 사용하지 않을 수 있고 그래야 예외처리 컨트롤러를 사용가능하다
public class Ch10SoldOutException extends RuntimeException {
//public class Ch10SoldOutException extends Exception {
	//정규화된 규격화된 사용자 exception 생성방법이 있다.
	public Ch10SoldOutException() {
		super("품절");
	}
	
	public Ch10SoldOutException(String message){
		super("message");
	}
}


