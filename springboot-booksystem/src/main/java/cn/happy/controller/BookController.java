package cn.happy.controller;

import cn.happy.entity.Books;
import cn.happy.service.IBooksService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author：  刘涛
 *
 * @create 2018-10-18 9:10
 */
@Controller
public class BookController {

    @Resource(name = "bookService")
    private IBooksService booksService;

    @RequestMapping("/addHtml")
    public String findAll(){
        return "/bookadd";
    }

    @RequestMapping("/addBook")
    public Object addBook(Books books, HttpServletResponse response){
        int count = booksService.addBook(books);
        if (count>0){
            try {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.print("<span style='color:red;padding-left:710px;'>添加成功！</span>");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            try {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.print("<span style='color:red;padding-left:710px;'>添加失败！</span>");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/index.html";
    }

    @RequestMapping("/booklist")
    @ResponseBody
    public Object findAll(@RequestParam(required = false,defaultValue = "1")int pageNum,@RequestParam(required = false,defaultValue = "12")int pageSize,String multiQuery,String bookname,
                          String bookAuthor,String bookPublish){
        System.out.println(bookname);
        PageInfo<Books> bookList = booksService.findAll((pageNum+1), pageSize,multiQuery,bookname,bookAuthor,bookPublish);
        return bookList;
    }
}
