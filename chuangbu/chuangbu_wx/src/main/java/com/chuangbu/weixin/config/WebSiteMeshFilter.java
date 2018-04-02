package com.chuangbu.weixin.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: WebSiteMeshFilter.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月25日 下午4:47:18
 * @version V1.0
 */
@Configuration
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/view/*", "/WEB-INF/views/admin_layout.jsp")
		.addExcludedPath("/index").addExcludedPath("/ajax/*");
	}
	
}