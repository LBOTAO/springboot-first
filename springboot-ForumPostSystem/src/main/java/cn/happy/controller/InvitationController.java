package cn.happy.controller;

import cn.happy.entity.Invitation;
import cn.happy.service.IInvitationService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 15:00
 */
@Controller
@RequestMapping("/Invitation")
public class InvitationController {
    @Resource
    private IInvitationService invitationService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "2") int pageSize, String title) {
        PageInfo<Invitation> info = invitationService.findAll(pageNum, pageSize, title);
        return info;
    }

    @RequestMapping("/delInvitation")
    public String delInvitation(int id, HttpServletResponse response) {
        boolean flag = invitationService.delInvitation(id);
        if (flag) {
            try {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter pw = response.getWriter();
                pw = response.getWriter();
                pw.flush();
                pw.print("<span style='color:red; padding-left:710px;'>删除成功！！！</span>");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter pw = response.getWriter();
                pw.flush();
                pw.print("<span style='color:red; padding-left:710px;'>删除失败！！！</span>");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "/index.html";
    }
}
