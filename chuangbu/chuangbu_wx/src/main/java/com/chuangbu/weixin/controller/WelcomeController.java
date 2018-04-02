package com.chuangbu.weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.core.service.hospital.TOrgMenuService;


@Controller
public class WelcomeController {

	@Autowired  
    private TOrgMenuService tOrgMenuService;
	@Autowired  
	private TAppConfigService tAppConfigService;
	
	@RequestMapping(value = "/")
	public String home(HttpServletRequest request) {
		/*Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			return "redirect:/index";
		} else {
			return "login";
		}*/
		String appId = getAppId(request);
		request.setAttribute(com.chuangbu.core.constants.Constants.ORG_MENU_KEY, tOrgMenuService.getTOrgMenu(appId));
		TAppConfig conf = tAppConfigService.getTAppConfig(appId);
		request.setAttribute(com.chuangbu.core.constants.Constants.ORG_APP_NAME, conf.getName());
		return "index";
	}

	private String getAppId(HttpServletRequest request) {
		String  appId = request.getParameter("appId");
		if(StringUtils.isBlank(appId)){
			HttpSession session = request.getSession(false);
			if (session != null) {
				appId = (String) session.getAttribute("appId");
			}
		}
		return appId;
	}

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {
		String appId = getAppId(request);
		request.setAttribute(com.chuangbu.core.constants.Constants.ORG_MENU_KEY, tOrgMenuService.getTOrgMenu(appId));
		TAppConfig conf = tAppConfigService.getTAppConfig(appId);
		request.setAttribute(com.chuangbu.core.constants.Constants.ORG_APP_NAME, conf.getName());
		return "index";
	}
	
}
