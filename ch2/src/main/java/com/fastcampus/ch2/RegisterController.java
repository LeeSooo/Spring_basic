package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl+shif+o 자동 import
public class RegisterController {
   @RequestMapping("/register/add") // 신규회원 가입 화면
//   @GetMapping("/register/add")
   public String register() {
      return "registerForm";
      
   }
   
   //@RequestMapping(value="/register/save", method=RequestMethod.POST) post만 허용
   @PostMapping("/register/save") // 4.3부터
   public String save(User user, Model m) throws Exception {
      // 1. 유효성 검사
      if(!isValid(user)) {
         String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
         
         m.addAttribute("msg", msg);
         return "forward:/register/add";
//         return "redirect:/register/add?msg="+msg; //URL재작성(rewriting)
      }
      
      // 2. DB에 신규회원 정보를 저장
      return "registerInfo";
   }

   private boolean isValid(User user) {
      return false;
   }
}