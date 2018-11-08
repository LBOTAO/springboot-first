package cn.custom.controller;

import cn.custom.springmvc.annotation.ExtController;
import cn.custom.springmvc.annotation.ExtRequestMapping;

/**
 * author：  刘涛
 *
 * @create 2018-10-27    14:17
 */
@ExtController
@ExtRequestMapping("/index")
public class IndexController {
    @ExtRequestMapping("/test")
    public String test(){
        System.out.println("呵呵哒，我是纯手写SpringMvc");
        return "index";
    }
}
