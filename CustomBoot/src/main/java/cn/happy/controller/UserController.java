package cn.happy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author：  刘涛
 *
 * @create 2018-11-01 9:47
 */
@Controller
public class UserController {
    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
