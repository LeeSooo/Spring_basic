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

// ��, ��, ���� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC {
	// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	
	// 1. �Է�
	@RequestMapping("/getYoilMVC") 
	public String main(int year, int month, int day, Model model) throws IOException {
		// - ��ȿ�� �˻�
		if(!isValiad(year, month, day))
			return "yoilError";
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
	    
	    // 3. ����� ����� model�� ����
	    model.addAttribute("year", year);
	    model.addAttribute("month", month);
	    model.addAttribute("day", day);
	    model.addAttribute("yoil", yoil);
	    
	    // 4. ���
	    return "yoil";	// /WEB-INF/views/yoil.jsp ���Ϸ� �̵�.

    }

	// �� Ŭ���� �ȿ����� ó���ؾ��ϱ� ������ private�� ����.
	private boolean isValiad(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		// 2. ó��
	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, day);
	
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 
	}
}