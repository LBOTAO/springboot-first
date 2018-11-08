package cn.custom.springmvc.servlet;

import cn.custom.springmvc.annotation.ExtController;
import cn.custom.springmvc.annotation.ExtRequestMapping;
import cn.custom.utils.ClassUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author：  刘涛
 *
 * @create 2018-10-27 10:40
 */
public class ExtDispatcherServlet extends HttpServlet {
    // springmvc 容器对象 key:类名id ,value 对象
    private ConcurrentHashMap<String, Object> springmvcBeans = new ConcurrentHashMap<String, Object>();
    // springmvc 容器对象 keya:请求地址 ,vlue类
    private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<String, Object>();
    // springmvc 容器对象 key:请求地址 ,value 方法名称
    private ConcurrentHashMap<String, String> urlMethods = new ConcurrentHashMap<String, String>();

    @Override
    public void init() throws ServletException {
        // 1.获取当前包下的所有的类
        List<Class<?>> classes = ClassUtil.getClasses("cn.custom.controller");
        // 2.将扫包范围所有的类,注入到springmvc容器里面，存放在Map集合中 key为默认类名小写，value 对象
        try {
            findClassMVCAnnotation(classes);
        } catch (Exception e) {
            // TODO: handle exception
        }
        // 3.将url映射和方法进行关联
        handlerMapping();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        // #################处理请求####################
        // 1.获取请求url地址
        String requestURI = req.getRequestURI();
        if (StringUtils.isEmpty(requestURI)) {
            return;
        }
        // 2.从Map集合中获取控制对象
        Object object = urlBeans.get(requestURI);
        if (object == null) {
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.getWriter().println("<h2 style='color:red;'>not found 404 url</h2>");
            return;
        }
        // 3.使用url地址获取方法
        String methodName = urlMethods.get(requestURI);
        if (StringUtils.isEmpty(methodName)) {
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.getWriter().println("<h2 style='color:red;'>not found method</h2>");
        }
        // 4.使用java的反射机制调用方法
        String resultPage = (String) methodInvoke(object, methodName);
        // 5.调用视图转换器渲染给页面展示
        extResourceViewResolver(resultPage, req, resp);

    }

    private void extResourceViewResolver(String pageName, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 根路径
        String prefix = "/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + pageName + suffix).forward(req, res);
    }

    private Object methodInvoke(Object object, String methodName) {
        try {
            Class<? extends Object> classInfo = object.getClass();
            Method method = classInfo.getMethod(methodName);
            Object result = method.invoke(object);
            return result;
        } catch (Exception e) {
            return null;
        }

    }

    // 2.将扫包范围所有的类,注入到springmvc容器里面，存放在Map集合中 key为默认类名小写，value 对象
    public void findClassMVCAnnotation(List<Class<?>> classes)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (Class<?> classInfo : classes) {
            // 判断类上是否有加上注解
            ExtController extController = classInfo.getDeclaredAnnotation(ExtController.class);
            if (extController != null) {
                // 默认类名是小写
                String beanId = ClassUtil.toLowerCaseFirstOne(classInfo.getSimpleName());
                // 实例化对象
                Object object = ClassUtil.newInstance(classInfo);
                springmvcBeans.put(beanId, object);
            }
        }
    }

    // 3.将url映射和方法进行关联
    public void handlerMapping() {
        // 1.遍历springmvc bean容器 判断类上属否有url映射注解
        for (Map.Entry<String, Object> mvcBean : springmvcBeans.entrySet()) {
            // 2.遍历所有的方法上是否有url映射注解
            // 获取bean的对象
            Object object = mvcBean.getValue();
            // 3.判断类上是否有加url映射注解
            Class<? extends Object> classInfo = object.getClass();
            ExtRequestMapping declaredAnnotation = classInfo.getDeclaredAnnotation(ExtRequestMapping.class);
            String baseUrl = "";
            if (declaredAnnotation != null) {
                // 获取类上的url映射地址
                baseUrl = declaredAnnotation.value();
            }
            // 4.判断方法上是否有加url映射地址
            Method[] declaredMethods = classInfo.getDeclaredMethods();
            for (Method method : declaredMethods) {
                // 判断方法上是否有加url映射注解
                ExtRequestMapping methodExtRequestMapping = method.getDeclaredAnnotation(ExtRequestMapping.class);
                if (methodExtRequestMapping != null) {
                    String methodUrl = baseUrl + methodExtRequestMapping.value();
                    // springmvc 容器对象 keya:请求地址 ,vlue类
                    urlBeans.put(methodUrl, object);
                    // springmvc 容器对象 key:请求地址 ,value 方法名称
                    urlMethods.put(methodUrl, method.getName());
                }
            }
        }

    }
}
