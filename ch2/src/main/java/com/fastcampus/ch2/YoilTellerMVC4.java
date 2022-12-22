package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC4 { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
   @ExceptionHandler(Exception.class)
   public String catcher(Exception ex) {
      ex.printStackTrace();
      return "yoilError";
   }
   
   @RequestMapping("/getYoilMVC4")
       //public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
      public String main(MyDate date, Model model) {
      // 1. ��ȿ�� �˻�
      if(!isValid(date))
         return "yoilError";

        // 2. ó��
        char yoil = getYoil(date);
        
        // 3. ����� ����� model�� ����
        model.addAttribute("myDate", date);
        model.addAttribute("yoil", yoil);
        
        // 4. ��ȯ(���)
        return "yoil"; //WEB-INF/views/yoil.jsp �� �����ش�
    }

	private boolean isValid(MyDate date) {
	   return isValid(date.getYear(), date.getMonth(), date.getDay());
	
	   }
	
	private char getYoil(MyDate date) {
	      return getYoil(date.getYear(), date.getMonth(), date.getDay());
	   }
	
	private boolean isValid(int year, int month, int day) {
	      return true;
	   }
	
	private char getYoil(int year, int month, int day) {
	   Calendar cal = Calendar.getInstance();
	   cal.set(year, month - 1, day);
	
	   int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	   return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 
	}
}