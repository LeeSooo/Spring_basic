package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class ModelController {
	public String main(HashMap map) {
		// 작업 결과를 map에 저장
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView1";	// 뷰 이름을 반환
	}
}

public class MethodCall {
	public static void main(String[] args) throws Exception{
		// 1. map 생성
		HashMap map = new HashMap();
		System.out.println("before:"+map);

		// 2. mc 객체의 map에 호출.
		ModelController mc = new ModelController();
		String viewName = mc.main(map);	
		
		System.out.println("after :"+map);
		
		// 3. 데이터와 뷰 이름을 render함수로 전송.
		render(map, viewName);
	}
	
	// 3. 데이터와 뷰 이름을 전송 받음.
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

/*
[txtView1.txt]
id=${id}, pwd=${pwd}

[txtView2.txt]
id:${id}
pwd:${pwd}



[실행결과]
before:{}
after :{id=asdf, pwd=1111}
[txtView2.txt]
id:asdf
pwd:1111*/