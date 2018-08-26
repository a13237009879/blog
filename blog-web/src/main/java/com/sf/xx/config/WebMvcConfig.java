package com.sf.xx.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import freemarker.template.TemplateException;
import freemarker.template.utility.XmlEscape;

/**
 * springMvc配置
 * 
 * @author admin
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) 
	{
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
		// 不显示为null的字段
		SimpleModule simpleModule = new SimpleModule();
		objectMapper.registerModule(simpleModule);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		// 放到第一个
		converters.add(0, jackson2HttpMessageConverter);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/index").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Bean
	public ViewResolver viewResolver() 
	{
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(false);
		resolver.setPrefix("");
		resolver.setSuffix(".html");
		resolver.setContentType("text/html; charset=UTF-8");
		resolver.setRequestContextAttribute("request");
		resolver.setExposeSpringMacroHelpers(true);
		resolver.setExposeSessionAttributes(true);
		resolver.setExposeRequestAttributes(true);
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException 
	{
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPaths("classpath:/templates/");
		configurer.setDefaultEncoding("UTF-8");
		Properties settings = new Properties();
        settings.setProperty("locale", "zh_CN");
		settings.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
		settings.setProperty("date_format", "yyyy-MM-dd");
		settings.setProperty("number_format", "#.##");
		settings.setProperty("boolean_format", "true,false");
		settings.setProperty("template_update_delay","1"); 
		configurer.setFreemarkerSettings(settings);
		Map<String, Object> variables = new HashMap<>();
		variables.put("xml_escape",  xmlEscape());
		configurer.setFreemarkerVariables(variables);
		return configurer;
	}
	
	@Bean
	public XmlEscape xmlEscape()
	{
		return new XmlEscape();
	}
}
