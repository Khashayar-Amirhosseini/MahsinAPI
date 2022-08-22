package com.MahSinApi.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserLogout {
    @RequestMapping("/logout.do")
    public String userLogout(HttpServletRequest request){
        System.out.println("user logout");
        System.out.println(request.getSession().getAttribute("MainId"));
        request.getSession().invalidate();
        return null;
    }
}
