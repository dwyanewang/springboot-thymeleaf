package com.dwyanewang;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类配置
        WebMvcConfigurer.super.configureMessageConverters(converters);
        //创建fastjson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
//                //输出key时是否使用双引号,默认为true
//                SerializerFeature.QuoteFieldNames,
//                //使用单引号而不是双引号,默认为false
//                SerializerFeature.UseSingleQuotes,
                //是否输出值为null的字段,默认为false
                SerializerFeature.WriteMapNullValue,
//                //Date使用ISO8601格式输出，默认为false
//                SerializerFeature.UseISO8601DateFormat,
//                //List字段如果为null,输出为[],而非null
//                SerializerFeature.WriteNullListAsEmpty,
                //字符类型字段如果为null,输出为”“,而非null
                SerializerFeature.WriteNullStringAsEmpty,
//                //数值字段如果为null,输出为0,而非null
//                SerializerFeature.WriteNullNumberAsZero,
//                //Boolean字段如果为null,输出为false,而非null
//                SerializerFeature.WriteNullBooleanAsFalse,
//                //将对象转为array输出
//                SerializerFeature.BeanToArray,
                //消除对同一对象循环引用的问题，默认为false
                SerializerFeature.DisableCircularReferenceDetect

//                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }
}
