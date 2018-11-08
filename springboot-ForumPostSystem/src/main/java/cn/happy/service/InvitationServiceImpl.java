package cn.happy.service;

import cn.happy.dao.IInvitationDao;
import cn.happy.entity.Invitation;
import cn.happy.entity.ReplyDetail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:56
 */
@Service("invitationService")
public class InvitationServiceImpl implements IInvitationService {
    @Resource(name = "IInvitationDao")
    private IInvitationDao invitationDao;
    @Override
    public PageInfo<Invitation> findAll(int pageNum,int pageSize,String title) {
        Page<Invitation> page = PageHelper.startPage(pageNum, pageSize);
        invitationDao.findAll(title);
        return page.toPageInfo();
    }

    @Override
    public boolean delInvitation(int id) {
        return invitationDao.delInvitation(id);
    }
}
