package com.fastcampus.ch2;

import java.lang.reflect.Method;	// 메소드 참조 시 사용

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main();	// private라서 외부 호출 불가
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다를 수 있는 강력한 기능 제공
		// java.lang.reflect패키지를 제공
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // newInstance() : Class객체가 가진 정보를 객체 생성
		
		// getDeclaredMethod()의 인자로 메소드의 파라미터 정보를 넘겨주면 일치하는 것을 찾아줍니다.
		Method main = hello.getClass().getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello);		// hello.main()과 동일함.
	}
}