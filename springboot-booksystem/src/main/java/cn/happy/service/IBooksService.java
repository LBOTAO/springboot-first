package cn.happy.service;

import cn.happy.entity.Books;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-18 9:06
 */
public interface IBooksService {

    public PageInfo<Books> findAll(int pageNum, int pageSize,String multiQuery,String bookname,
                                   String bookAuthor,String bookPublish);

    public int addBook(Books books);

}
