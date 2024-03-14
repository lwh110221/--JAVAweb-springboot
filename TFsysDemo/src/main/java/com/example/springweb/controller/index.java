package com.example.springweb.controller;

import com.example.springweb.pojo.Login;
import com.example.springweb.service.loginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class index {
    @Resource(name = "loginService")
    loginService loginService;
    @GetMapping("/login")
    public String loginIn(){
        return "login/login";
    }
    @PostMapping("/login")
    public String loginIn(Login viewLogin, Model model, HttpSession session){
        Map<String,Object> map=loginService.loginIn(viewLogin,session);
        if(map.get("message").equals("登录成功")) return "redirect:/student/list";
        else{
            model.addAttribute("str",map.get("message"));
            return "login/login";
        }
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login/login";
    }
    @PostMapping("/register")
    @ResponseBody
    public Map<String,Object> abc(Login viewLogin){
        return loginService.addUser(viewLogin);
    }
    @GetMapping("/register")
    public String toRegister(){
        return "login/register";
    }
    @GetMapping("/validMail")
    public String validMail(String confirmCode, Model model){
        Map<String,Object> map=loginService.validMail(confirmCode);
        model.addAttribute("str",map);
        return "login/validSuccess";
    }
}
