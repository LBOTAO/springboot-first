package cn.happy.controller;

import cn.happy.entity.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * author：  刘涛
 *
 * @create 2018-08-10 16:01
 */
@Controller
public class TestController {
    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(){
        Demo demo=new Demo();
        demo.setId(1);
        demo.setName("王嘉尔");
        demo.setCreatedate(new Date());
        return demo;
    }
}
