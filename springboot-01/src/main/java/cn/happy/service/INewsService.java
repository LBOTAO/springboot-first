package cn.happy.service;

import cn.happy.entity.NewsModel;

import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-03 10:58
 */
public interface INewsService {
    public List<NewsModel> findAll();
    public List<NewsModel> findByAuthor(String authorname);
}
