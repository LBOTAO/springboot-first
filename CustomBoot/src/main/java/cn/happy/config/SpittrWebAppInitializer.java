package cn.happy.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * springmvc加载dispatcherServet
 * author：  刘涛
 *
 * @create 2018-10-30 12:23
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载根配置信息   springmvc核心
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    //springmvc加载配置信息
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //springmvc  拦截url映射
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
