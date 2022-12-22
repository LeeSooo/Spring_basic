package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC6 { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
   @ExceptionHandler(Exception.class)
   public String catcher(Exception ex, BindingResult result) {
      System.out.println("result = "+result);
      FieldError error = result.getFieldError();
      
      System.out.println("code="+error.getCode());
      System.out.println("field="+error.getField());
      System.out.println("msg="+error.getDefaultMessage());
      ex.printStackTrace();
      return "yoilError";
   }
   
   @RequestMapping("/getYoilMVC6")
      public String main(MyDate date, BindingResult result) {   
      System.out.println("result = "+result);
      // 1. 유효성 검사
      if(!isValid(date))
         return "yoilError";
        
        // 4. 반환(출력)
        return "yoil"; 

        
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

private @ModelAttribute("yoil") char getYoil(int year, int month, int day) {
   Calendar cal = Calendar.getInstance();
   cal.set(year, month - 1, day);

   int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
   return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
}
}