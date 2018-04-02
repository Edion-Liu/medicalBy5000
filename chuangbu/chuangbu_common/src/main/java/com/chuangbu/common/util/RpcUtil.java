package com.chuangbu.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chuangbu.common.util.des3.Des3Util;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年8月27日 下午8:05:23
 */

public class RpcUtil {

	public static String getToken(String key) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
		String dateString = formatter.format(new Date());
		String token = Des3Util.encode(key + dateString);
		token = token.replaceAll("\\+", "\\-");
		return token;
	}
}
