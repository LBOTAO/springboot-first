package cn.happy.dao;

import cn.happy.entity.Invitation;
import cn.happy.entity.ReplyDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:53
 */
public interface IInvitationDao {

    public List<Invitation> findAll(@Param(value = "title") String title);

    public boolean delInvitation(int id);

}
