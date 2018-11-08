package cn.happy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author：  刘涛
 *
 * @create 2018-11-01 8:41
 */
@RestController
public class IndexController {

    @RequestMapping(name = "/index", produces = "text/html;charset=UTF-8")
    public String index(){
        return "呵呵哒";
    }

}
