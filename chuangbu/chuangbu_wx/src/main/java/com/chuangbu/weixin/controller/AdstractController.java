package com.chuangbu.weixin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.weixin.constants.Constants;

/**
 * @Title: AdstractController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月3日 下午3:50:24
 * @version V1.0
 */
public abstract class AdstractController {

	final Map<String, String> FAIL = new HashMap<String, String>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 4682657553985783523L;

		{
			put("status", "no");
			put("code", "999999");
			put("msg", "没有获取数据失败！");
		}
	};

	final Map<String, String> SECCESS = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3318687418948001717L;

		{
			put("status", "ok");
			put("code", "000000");
			put("msg", "成功！");
		}
	};

	String getToken() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
		String dateString = formatter.format(new Date());
		String token = Des3Util.encode(Constants.RPC_KEY + dateString);
		token = token.replaceAll("\\+", "\\-");
		return token;
	}
	
	String getAppId(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session == null) {
			return null;
		}
		
		return (String) session.getAttribute("appId");
	}
	
}
