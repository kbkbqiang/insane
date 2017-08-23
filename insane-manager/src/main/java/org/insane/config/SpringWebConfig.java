package org.insane.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
/*
 * @ComponentScan(basePackages = { "com.zq.server.controller",
 * "com.zq.server.service", "com.zq.server.filter", "org.insane.config",
 * "com.backend.dao"})
 */
@ComponentScan(basePackages = { 
		"org.insane.controller", 
		"org.insane.service", 
		})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	/**
	 * spring
	 * boot默认使用的json转换工具是jackson,通过重写configureMessageConverters方法使用fastjson工具类
	 * 
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 定义一个转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 在转换器中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 将转换器添加到converters中
		converters.add(fastConverter);
	}

}
