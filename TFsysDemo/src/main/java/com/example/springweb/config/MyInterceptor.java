package com.example.springweb.config;

import com.example.springweb.pojo.Login;
import com.example.springweb.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Login login=(Login) session.getAttribute("USER");
        if(login!=null){
            return true;
        }else {
            request.setAttribute("str","请先登录");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
    }
}
