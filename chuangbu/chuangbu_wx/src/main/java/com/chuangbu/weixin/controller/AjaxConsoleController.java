package com.chuangbu.weixin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.orm.hospital.domain.TOrgMenu;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.core.service.hospital.TOrgMenuService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/ajax/console/")
public class AjaxConsoleController extends AdstractController{
	private static final Logger logger = LoggerFactory.getLogger(AjaxConsoleController.class);
	
	@Autowired
	private TOrgMenuService tOrgMenuService;
	
	@Autowired
	private TAppConfigService tAppConfigService;

	@RequestMapping(value = "/refresh/config")
	@ResponseBody
	public String refreshConfig() {
		try{
			tAppConfigService.cleanAll();
			logger.info("初始化微信支付配置信息开始。。。。。。");
			tAppConfigService.initRedisTAppConfig();
			logger.info("初始化微信支付配置信息结束。。。。。。");
			logger.info("初始化菜单配置信息开始。。。。。。");
	    	List<TAppConfig> confs = tAppConfigService.findAll();
	    	for(TAppConfig conf : confs){
	    		TOrgMenu menu = new TOrgMenu();
	    		menu.setOrgId(conf.getOrgId());
	    		tOrgMenuService.initRedisMenu(menu);
	    	}
	    	logger.info("初始化菜单配置信息结束。。。。。。");
			return JSONObject.fromObject(SECCESS).toString();
		}catch(Exception e){
			logger.error("初始化微信配置失败",e);
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	@RequestMapping(value = "/refresh/menu")
	@ResponseBody
	public String refreshMenu() {
		try{
			
			return JSONObject.fromObject(SECCESS).toString();
		}catch(Exception e){
			logger.error("初始化微信支付配置失败",e);
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	

}
