package cn.happy.dao;

import cn.happy.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-02 9:03
 */
public interface IUserInfoDao {

    public UserInfo isLogin(UserInfo userInfo);

    public List<UserInfo> findAll(@Param("likeUserName") String likeUserName,@Param("conditionUserRole") Integer conditionUserRole);

    public int delUserInfo(int id);

    public int insertUserInfo(UserInfo userInfo);

    public int deleteList(List<String> list);

}
