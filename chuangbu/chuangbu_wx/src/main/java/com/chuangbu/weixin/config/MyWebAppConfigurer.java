package com.chuangbu.weixin.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.orm.hospital.domain.TOrgMenu;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.core.service.hospital.TOrgMenuService;

/**   
* @Title: MyWebAppConfigurer.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午9:19:22 
* @version V1.0   
*/
@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWebAppConfigurer.class);
 
	@Value("${static.path:F:/Workspaces/SVN/static/}")
    private String staticPath = "F:/Workspaces/SVN/static/";
	
	@Autowired
	private TOrgMenuService tOrgMenuService;
	
	@Autowired
	private TAppConfigService tAppConfigService;
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	logger.info("staticPath:{}",staticPath);
        registry.addResourceHandler("/myres/**").addResourceLocations("file:"+staticPath);
        super.addResourceHandlers(registry);
        
        initTencentPayConfig();
    }
    
    private void initTencentPayConfig(){
    	logger.info("初始化微信支付配置信息开始。。。。。。");
    	tAppConfigService.initRedisTAppConfig();
    	logger.info("初始化微信支付配置信息结束。。。。。。");
    	
    	logger.info("初始化页面配置信息开始。。。。。。");
    	List<TAppConfig> confs = tAppConfigService.findAll();
    	for(TAppConfig conf : confs){
    		TOrgMenu menu = new TOrgMenu();
    		menu.setOrgId(conf.getOrgId());
    		tOrgMenuService.initRedisMenu(menu);
    	}
    	/*SysOrganization org = new SysOrganization();
    	org.setParent("0");
    	List<SysOrganization> orgs = sysOrganizationService.find(org);
    	for(int i =0 ; i< orgs.size() ; i++){
    		String id = orgs.get(i).getId();
    		TOrgMenu menu = new TOrgMenu();
    		menu.setOrgId(id);
    		tOrgMenuService.initRedisMenu(menu);
    	}*/
    	logger.info("初始化页面配置信息结束。。。。。。");
    	
    }
}
