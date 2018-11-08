package cn.happy.service;

import cn.happy.dao.IReplyDetailDao;
import cn.happy.entity.ReplyDetail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-26 13:54
 */
@Service("replyDetailService")
public class ReplyDetailServiceImpl implements IReplyDetailService{
    @Resource(name = "IReplyDetailDao")
    private IReplyDetailDao replyDetailDao;


    @Override
    public PageInfo<ReplyDetail> findReplyDetailAll(int invid,int pageNum,int pageSize) {
        Page<ReplyDetail> replyDetailPage = PageHelper.startPage(pageNum, pageSize);
        replyDetailDao.findReplyDetailAll(invid);
        return replyDetailPage.toPageInfo();
    }

    @Override
    public int insertReply(ReplyDetail replyDetail) {
        return replyDetailDao.insertReply(replyDetail);
    }
}
