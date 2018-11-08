package cn.happy.controller;

import cn.happy.entity.GetIds;
import cn.happy.entity.UserInfo;
import cn.happy.service.IUserInfoService;
import cn.happy.util.BirthdayconvertAgeUtil;
import cn.happy.util.LayuiUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-02 9:36
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Resource(name = "userInfoService")
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/deleteList")
    @ResponseBody
    public String deleteList(String ids){
        List<String> list=new ArrayList<String>();
        String[] split = ids.split(",");
        for (String item:split){
            list.add(item);
        }
       int count = userInfoService.deleteList(list);
        if (count>0){
            return "y";
        }else{
            return "n";
        }
    }

    @RequestMapping(value = "/insertUserInfo")
    @ResponseBody
    public String insertUserInfo(UserInfo userInfo){
        int count = userInfoService.insertUserInfo(userInfo);
        if (count>0){
            return "y";
        }else{
            return "n";
        }
    }

    @RequestMapping(value = "/delUserInfo")
    @ResponseBody
    public String delUserInfo(int id){
        int count = userInfoService.delUserInfo(id);
        if (count>0){
            return "y";
        }else{
            return "n";
        }
    }


    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Object findAll(@RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "5")int pageSize,
                          String likeUserName,Integer conditionUserRole) throws Exception {
        PageInfo<UserInfo> userList = userInfoService.findAll((pageNum-1), pageSize,likeUserName,conditionUserRole);
       /* for (UserInfo user:userList.getList()){
            int age = BirthdayconvertAgeUtil.getAge(user.getBirthday());
            user.setAge(age);
        }*/
        return LayuiUtil.data((int) userList.getTotal(),userList.getList());
    }



    @RequestMapping(value = "/isLogin")
    @ResponseBody
    public String isLogin(UserInfo userInfo, HttpSession session, HttpServletRequest request) throws IOException {
        UserInfo login = userInfoService.isLogin(userInfo);
        if (login!=null){
            session.setAttribute("userName",login.getUserName());
            return "success";
        }else {
            request.getSession().setAttribute("msg","用户名或密码错误！");
            return "fail";
        }
    }

}
