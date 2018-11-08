package cn.happy.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author：  刘涛
 *  json解析工具
 * @create 2018-08-10 13:39
 */
@Configuration  //将物理类变成配置文件
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //构建一个HttpMessageConvereter   http消息转换器
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
        //定义一个配置 设置编码方式  和格式化的方式
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        //设置成了prettyFormat格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码
        List<MediaType> fastMediaTypes=new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}
