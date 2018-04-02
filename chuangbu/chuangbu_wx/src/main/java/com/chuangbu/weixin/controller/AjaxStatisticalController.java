package com.chuangbu.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.common.util.HttpRequestUtils;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.weixin.constants.Constants;


@Controller
@RequestMapping(value = "/ajax/statistical/")
public class AjaxStatisticalController extends AdstractController{
	
	@Autowired
    private TAppConfigService tAppConfigService;
	
	@RequestMapping(value = "/global/data")
	@ResponseBody
	public String globalData(HttpServletRequest request) {
		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		String url = String.format(Constants.RPC_STATISTICAL_GLOBAL_URL,conf.getRpcUrl(),getToken());
		String result = HttpRequestUtils.httpPost(url, null);
		return result;
	}
	
}
