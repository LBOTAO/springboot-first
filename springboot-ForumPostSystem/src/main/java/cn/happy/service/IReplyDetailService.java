package cn.happy.service;

import cn.happy.entity.ReplyDetail;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-26 13:53
 */
public interface IReplyDetailService {
    public PageInfo<ReplyDetail> findReplyDetailAll(int invid,int pageNum,int pageSize);

    public int insertReply(ReplyDetail replyDetail);
}
