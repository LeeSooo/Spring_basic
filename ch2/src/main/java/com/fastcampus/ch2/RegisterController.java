package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl+shif+o �ڵ� import
public class RegisterController {
   @RequestMapping("/register/add") // �ű�ȸ�� ���� ȭ��
//   @GetMapping("/register/add")
   public String register() {
      return "registerForm";
      
   }
   
   //@RequestMapping(value="/register/save", method=RequestMethod.POST) post�� ���
   @PostMapping("/register/save") // 4.3����
   public String save(User user, Model m) throws Exception {
      // 1. ��ȿ�� �˻�
      if(!isValid(user)) {
         String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
         
         m.addAttribute("msg", msg);
         return "forward:/register/add";
//         return "redirect:/register/add?msg="+msg; //URL���ۼ�(rewriting)
      }
      
      // 2. DB�� �ű�ȸ�� ������ ����
      return "registerInfo";
   }

   private boolean isValid(User user) {
      return false;
   }
}