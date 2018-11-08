package cn.happy.service;

import cn.happy.dao.IBooksDao;
import cn.happy.entity.Books;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author：  刘涛
 *
 * @create 2018-10-18 9:07
 */
@Service("bookService")
public class BooksServiceImpl implements IBooksService{
    @Resource(name = "IBooksDao")
    private IBooksDao booksDao;

    @Override
    public PageInfo<Books> findAll(int pageNum, int pageSize,String multiQuery,String bookname,
                                   String bookAuthor,String bookPublish) {
        Page<Books> pages = PageHelper.startPage(pageNum, pageSize);
        booksDao.findAll(multiQuery,bookname,bookAuthor,bookPublish);
        return pages.toPageInfo();
    }

    @Override
    public int addBook(Books books) {
        return booksDao.addBook(books);
    }
}
