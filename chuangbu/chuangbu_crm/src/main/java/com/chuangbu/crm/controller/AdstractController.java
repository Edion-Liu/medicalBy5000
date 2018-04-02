package com.chuangbu.crm.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: AdstractController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月3日 下午3:50:24
 * @version V1.0
 */
@SuppressWarnings("serial")
public abstract class AdstractController {

	final Map<String, Object> FAIL = new HashMap<String, Object>() {
		{
			put("status", "no");
			put("code", "999999");
			put("msg", "失败！");
		}
	};

	final Map<String, Object> SECCESS = new HashMap<String, Object>() {
		{
			put("status", "ok");
			put("code", "000000");
			put("msg", "成功！");
		}
	};

	
}
