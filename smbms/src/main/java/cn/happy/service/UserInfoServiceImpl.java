package cn.happy.service;

import cn.happy.dao.IUserInfoDao;
import cn.happy.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-11-02 9:34
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource(name = "IUserInfoDao")
    private IUserInfoDao userInfoDao;

    @Override
    public UserInfo isLogin(UserInfo userInfo) {
        return userInfoDao.isLogin(userInfo);
    }

    @Override
    public PageInfo<UserInfo> findAll(int pageNum,int pageSize,String likeUserName,Integer conditionUserRole) {
        Page<UserInfo> userInfoPage = PageHelper.startPage((pageNum+1), pageSize);
        userInfoDao.findAll(likeUserName,conditionUserRole);
        return userInfoPage.toPageInfo();
    }

    @Override
    public int delUserInfo(int id) {
        return userInfoDao.delUserInfo(id);
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public int deleteList(List<String> list) {
        return userInfoDao.deleteList(list);
    }
}
