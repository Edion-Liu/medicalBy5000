package com.chuangbu.crm;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.chuangbu.crm.shiro.bean.ShiroInit;

/**
 * @Title: StartWeiXinApp.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年1月3日 下午6:05:19
 * @version V1.0
 */
@ComponentScan
@ServletComponentScan
@SpringBootApplication
@ImportResource(value = { "classpath:/config/application-context.xml" })
@PropertySource(value = "classpath:config/application.properties", ignoreResourceNotFound = true)
public class StartCRMApp {

	public static void main(String[] args) throws Exception {
		ShiroInit.init();
		SpringApplication.run(StartCRMApp.class, args);
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	/*@Bean
	public ServletListenerRegistrationBean<MyServletContextListener> testListenerRegistration() {
		ServletListenerRegistrationBean<MyServletContextListener> registration = new ServletListenerRegistrationBean<MyServletContextListener>(
				new MyServletContextListener());
		return registration;
	}*/
}
