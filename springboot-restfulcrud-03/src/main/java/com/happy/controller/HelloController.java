package com.happy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-10-13 10:05
 */
@Controller
public class HelloController {
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>正阳门下</h1>");
        map.put("hehe", Arrays.asList("韩春明","苏萌","破烂侯","督门提酒"));
        return "success";
    }
}
