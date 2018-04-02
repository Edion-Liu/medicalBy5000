package com.chuangbu.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chuangbu.common.util.JSONUtil;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.orm.hospital.domain.TOrgMenu;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.core.service.hospital.TOrgMenuService;
import com.chuangbu.weixin.util.MD5Utils;


@Controller
@RequestMapping(value = "/view/common/")
public class ViewController extends AdstractController{
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewController.class);
	@Autowired
	private TOrgMenuService tOrgMenuService;
	@Autowired
	private TAppConfigService tAppConfigService;
	
	@RequestMapping(value = "/otherPage")
	public String otherPage(HttpServletRequest request ,@RequestParam("menuUrl") String menuUrl) {
		menuUrl = menuUrl.replaceAll("======", "/");
		menuUrl = new String(MD5Utils.decode(menuUrl));
		request.setAttribute("menuUrl", menuUrl);
		return "/otherPage";
	}
	@RequestMapping(value = "/subMenu")
	public String subMenu(HttpServletRequest request ,@RequestParam("menuId") String menuId) {
		TOrgMenu menu = new TOrgMenu();
		menu.setParent(menuId);
		menu.setValid((short) 1);
		menu.setOrderBy(" dis_order ");
		request.setAttribute("menuData", JSONUtil.toJson(tOrgMenuService.find(menu)));
		return "/sub_menu";
	}
	
	@RequestMapping(value = "/synopsis")
	public String synopsis(HttpServletRequest request ,@RequestParam("menuId") String menuId) {
		TOrgMenu menu = new TOrgMenu();
		menu.setParent(menuId);
		menu.setValid((short) 1);
		menu.setOrderBy(" dis_order ");
		request.setAttribute("menuData", JSONUtil.toJson(tOrgMenuService.find(menu)));
		return "/synopsis/synopsis";
	}
	
	@RequestMapping(value = "/doctorProfile")
	public String doctorProfile(HttpServletRequest request) {
		return "/doctorprofile/doctorProfile";
	}
	@RequestMapping(value = "/dept")
	public String dept(HttpServletRequest request) {
		return "/dept/dept";
	}
	@RequestMapping(value = "/navigation")
	public String navigation(HttpServletRequest request) {
		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		request.setAttribute("appConf", JSONUtil.toJson(conf));
		return "/navigation/navigation_net";
	}
	
	@RequestMapping(value = "/{viewId}")
	public String common(HttpServletRequest request	,@PathVariable String viewId) {
		String path = viewId;
		if(StringUtils.isBlank(path)){
			return "404";
		}
		try {
			path = path.replaceAll("======", "/");
			path = new String(MD5Utils.decode(path));
			if(path.contains("?")){
				String[] paths = path.split("\\?");
				String[] params = paths[1].split("&");
				for(String param : params){
					String[] paramv = param.split("=");
					request.setAttribute(paramv[0], paramv[1]);
				}
				path = paths[0];
			}
			if(path.contains("office") || path.contains("console")){
				return "404";
			}
			if(path.contains("register")){
				if(request.getParameter("code") != null){
					request.setAttribute("code", request.getParameter("code"));
				}
				return path;
			}
		} catch (Exception e) {
			LOGGER.warn("请求失败，url编码解析有问题:viewId[{}];path:{}",viewId,path);
			path = "500";
		}
		return path;
	}

	@RequestMapping(value = "/search")
	public String seach(HttpServletRequest request) {
		return "/search/search";
	}
}
