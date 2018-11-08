package cn.happy.tomcat;

import cn.happy.tomcat.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * author：  刘涛
 *
 * @create 2018-10-29 17:27
 */
public class Test001 {
    private static int PORT=8080;
    private static String CONTEXT_PATH="/happy";
    private static String SERVLET_NAME="/indexServlet";
    public static void main(String[] args) throws LifecycleException {

        //创建tomcat容器
        Tomcat tomcatServer=new Tomcat();
        //指定端口号
        tomcatServer.setPort(PORT);
        //是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext=new StandardContext();
        standardContext.setPath(CONTEXT_PATH);
        //监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //tomcat容器添加到standardContext
        tomcatServer.getHost().addChild(standardContext);

        //常见servlet
        tomcatServer.addServlet(CONTEXT_PATH,SERVLET_NAME,new IndexServlet());

        //创建servlet映射
        standardContext.addServletMappingDecoded("/index",SERVLET_NAME);

        tomcatServer.start();
        System.out.println("Tomcat started successfully......");
        //异步进行接受请求
        tomcatServer.getServer().await();
    }
}
