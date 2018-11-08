package cn.happy.dao;

import cn.happy.entity.NewsModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-03 10:56
 */
public interface INewsDao {
    public List<NewsModel> findAll();

    public List<NewsModel> findByAuthor(String authorname);
}
