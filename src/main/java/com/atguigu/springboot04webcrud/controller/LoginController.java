package com.atguigu.springboot04webcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * login
     * @param username
     * @param password
     * @param resultMap
     * @param httpSession
     * @return
     */
    @PostMapping("/user/login")
    public String login(String username,String password, Map<String,Object> resultMap,HttpSession httpSession) {
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";

        } else {
            resultMap.put("msg","用户名密码错误");
            return "login";
        }

    }
}
