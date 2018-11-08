package cn.happy.service.impl;

import cn.happy.dao.INewsDao;
import cn.happy.entity.NewsModel;
import cn.happy.service.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-03 10:59
 */
@Service("newsService")
public class NewsServiceImpl implements INewsService {
    @Resource(name = "INewsDao")
    private INewsDao dao;

    @Override
    public List<NewsModel> findAll() {
        return dao.findAll();
    }

    @Override
    public List<NewsModel> findByAuthor(String authorname) {
        return dao.findByAuthor(authorname);
    }

}
