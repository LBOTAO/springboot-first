package cn.happy.dao;

import cn.happy.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-10-18 8:52
 */
public interface IBooksDao {
    public List<Books> findAll(@Param("multiQuery") String multiQuery,@Param("bookname") String bookname,
                               @Param("bookAuthor") String bookAuthor,@Param("bookPublish") String bookPublish);

    public int addBook(Books books);

}
