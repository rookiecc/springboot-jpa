package com.example.jpa.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class JsonConfigure {

	//
	// @Bean
	// public ObjectMapper objectMapper() {
	// return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	// }

	@Bean
	public HttpMessageConverters fastJsonConfigure() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 日期格式化
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		// 解决乱码的问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setFastJsonConfig(fastJsonConfig);
		converter.setSupportedMediaTypes(fastMediaTypes);
		return new HttpMessageConverters(converter);
	}

}
