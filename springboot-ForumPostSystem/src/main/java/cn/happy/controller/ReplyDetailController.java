package cn.happy.controller;

import cn.happy.entity.ReplyDetail;
import cn.happy.service.IReplyDetailService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author：  刘涛
 *
 * @create 2018-10-26 13:56
 */
@Controller
@RequestMapping("/replyDetail")
public class ReplyDetailController {
    @Resource(name = "replyDetailService")
    private IReplyDetailService replyDetailService;

    @RequestMapping("/transfer")
    public String transfer(String invid, HttpSession session){
        session.setAttribute("id",invid);
        return "/replylist";
    }

    @RequestMapping("/findReplyDetailAll")
    @ResponseBody
    public Object findReplyDetailAll(int invid, @RequestParam(required = false,defaultValue = "1")int pageNum,
                                     @RequestParam(required = false,defaultValue = "2")int pageSize){
        PageInfo<ReplyDetail> replyDetailAll = replyDetailService.findReplyDetailAll(invid,pageNum, pageSize);

        return replyDetailAll;
    }

    @RequestMapping("/insertReply")
    @ResponseBody
    public String insertReply(ReplyDetail replyDetail){
        int count = replyDetailService.insertReply(replyDetail);
        if (count>0){
            return "success";
        }else {
            return "fail";
        }
    }
}
