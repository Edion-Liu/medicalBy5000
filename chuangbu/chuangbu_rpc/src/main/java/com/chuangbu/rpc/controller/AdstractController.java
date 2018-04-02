package com.chuangbu.rpc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.rpc.constants.RPCConstants;

/**
 * @Title: AdstractController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月3日 下午3:50:24
 * @version V1.0
 */
public abstract class AdstractController {

	@SuppressWarnings("serial")
	final Map<String, String> FAIL = new HashMap<String, String>() {
		{
			put("status", "no");
			put("code", "999999");
			put("msg", "获取数据失败！");
		}
	};

	@SuppressWarnings("serial")
	final Map<String, String> SECCESS = new HashMap<String, String>() {
		{
			put("status", "ok");
			put("code", "000000");
			put("msg", "成功！");
		}
	};

	boolean validateToken(String token) {
		token = token.replaceAll("\\-", "\\+");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
		String dateString = formatter.format(new Date());
		String vidToken = Des3Util.encode(RPCConstants.RPC_KEY + dateString);
		return StringUtils.isNotBlank(token) && token.equals(vidToken);
	}

}
