package cn.happy.dao;

import cn.happy.entity.ReplyDetail;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-26 13:53
 */
public interface IReplyDetailDao {
    public List<ReplyDetail> findReplyDetailAll(int invid);

    public int insertReply(ReplyDetail replyDetail);
}
