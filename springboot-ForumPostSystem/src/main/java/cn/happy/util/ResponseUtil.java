package cn.happy.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author：  刘涛
 *
 * @create 2018-07-06 16:45
 */
public class ResponseUtil {

    public static void wirte(HttpServletResponse response,Object obj) throws IOException {
        //设置内容类型及编码格式
        response.setContentType("text/html;charset=utf-8");
        //拿到response的文本输出流对象
        PrintWriter out = response.getWriter();
        //将返回的json对象写入到response中
        out.print(obj.toString());
        //刷新并关闭输出流
        out.flush();
        out.close();
    }
}
