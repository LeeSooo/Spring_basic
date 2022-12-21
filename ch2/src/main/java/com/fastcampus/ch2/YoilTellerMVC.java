package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;

// 년, 월, 일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
	// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	
	// 1. 입력
	@RequestMapping("/getYoilMVC") 
	public String main(int year, int month, int day, Model model) throws IOException {
		// - 유효성 검사
		if(!isValiad(year, month, day))
			return "yoilError";
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
	    
	    // 3. 계산한 결과를 model에 저장
	    model.addAttribute("year", year);
	    model.addAttribute("month", month);
	    model.addAttribute("day", day);
	    model.addAttribute("yoil", yoil);
	    
	    // 4. 출력
	    return "yoil";	// /WEB-INF/views/yoil.jsp 파일로 이동.

    }

	// 이 클래스 안에서만 처리해야하기 때문에 private로 선언.
	private boolean isValiad(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		// 2. 처리
	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, day);
	
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}
}