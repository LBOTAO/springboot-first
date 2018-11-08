package com.happy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-10-16 11:06
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String isLogin(@RequestParam("username")String username,
                          @RequestParam("userpwd")String userpwd, Map<String,Object> map,
                          HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123".equals(userpwd)){
            session.setAttribute("userlogin",username);
            //登录成功
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误！！！");
            return "login";
        }
    }

}
