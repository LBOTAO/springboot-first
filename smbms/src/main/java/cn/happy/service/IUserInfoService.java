package cn.happy.service;

import cn.happy.entity.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-02 9:34
 */
public interface IUserInfoService {
    public UserInfo isLogin(UserInfo userInfo);

    public PageInfo<UserInfo> findAll(int pageNum, int pageSize,String likeUserName,Integer conditionUserRole);

    public int delUserInfo(int id);

    public int insertUserInfo(UserInfo userInfo);

    public int deleteList(List<String> list);



}
