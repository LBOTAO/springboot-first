package cn.happy.controller;

import cn.happy.entity.NewsModel;
import cn.happy.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-08-03 11:00
 */
@Controller
public class NewsController {
    @Resource(name = "newsService")
    private INewsService newsService;

    //页面的跳转
    @RequestMapping("/goHome")
    public String goHome(){
        return "index";
    }

    @RequestMapping("/goaddPage")
    public String goaddPage(){
        return "addnews";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        List<NewsModel> list = newsService.findAll();
        return list;
    }
    @RequestMapping("/findByAuthor")
    @ResponseBody
    public Object findByAuthor(String authorname){
        return  newsService.findByAuthor(authorname);
    }
}
