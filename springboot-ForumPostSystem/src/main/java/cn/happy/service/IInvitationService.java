package cn.happy.service;

import cn.happy.entity.Invitation;
import cn.happy.entity.ReplyDetail;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:53
 */
public interface IInvitationService {

    public PageInfo<Invitation> findAll(int pageNum,int pageSize,String title);

    public boolean delInvitation(int id);
}
