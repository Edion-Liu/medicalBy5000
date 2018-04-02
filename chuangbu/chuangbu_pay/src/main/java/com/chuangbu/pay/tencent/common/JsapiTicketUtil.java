package com.chuangbu.pay.tencent.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chuangbu.common.util.HttpRequestUtils;

import net.sf.json.JSONObject;

/**
 * 说 明 : V型知识库 www.vxzsk.com
 * 
 * @author 作 者：xjc 邮 箱：361cjx@163.com
 * @version 版 本：V1.0 时 间：2017年5月1日 下午10:08:24
 */

public class JsapiTicketUtil {
	private static Logger logger = LoggerFactory.getLogger(JsapiTicketUtil.class);    //日志记录
	
	private static Map<String,Object> jsapiTicketMap = new HashMap<String,Object>();
	
	private static final long timeLimit = 7100000;

	/***
	 * 模拟get请求
	 * 
	 * @param url
	 * @param charset
	 * @param timeout
	 * @return
	 */
	public static String sendGet(String url, String charset, int timeout) {
		String result = "";
		try {
			URL u = new URL(url);
			try {
				URLConnection conn = u.openConnection();
				conn.connect();
				conn.setConnectTimeout(timeout);
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
				String line = "";
				while ((line = in.readLine()) != null) {

					result = result + line;
				}
				in.close();
			} catch (IOException e) {
				return result;
			}
		} catch (MalformedURLException e) {
			return result;
		}

		return result;
	}

	/***
	 * 获取acess_token 来源www.vxzsk.com
	 * appid  应用ID
	 * appSecret  (应用密钥)
	 * @return
	 */
	public static String getAccessToken(String appId,String appSecret) {
		String url = String.format(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId,
				appSecret);
		String backData = AcessToken.sendGet(url, "utf-8", 10000);
		String accessToken = (String) JSONObject.fromObject(backData).get("access_token");
		return accessToken;
	}
	
	/**
	 * 获取用户的openId，并放入session
	 * @param code 微信返回的code
	 */
	public static String getOpenId(String code,String appId,String appSecret) {
		String openid_url = String.format(Configure.PAY_OPENID_URL, appId, appSecret,
				String.valueOf(code));
		logger.info("openid_url:" + openid_url);
		JSONObject jsonObject = HttpRequestUtils.httpPostJSON(openid_url, null);
		logger.info("jsonObject:" + jsonObject.toString());
		Object errorCode = jsonObject.get("errcode");
		if (errorCode != null) {
			logger.info("code不合法");
			return null;
		} else {
			String openId = jsonObject.getString("openid");
			logger.info("openId:" + openId);
			return openId;
		}
//		return result;
	}
	/**
	 * 获取用户的openId，并放入session
	 * @param 调整url 微信返回的code
	 */
	public static String getCode(String redirectUri,String appId) {
		String code_url = String.format(Configure.PAY_OPENID_CODE_URL, appId, redirectUri);
		logger.info("code_url:{}" , code_url);
		JSONObject jsonObject = HttpRequestUtils.httpPostJSON(code_url, null);
		logger.info("jsonObject:{}" , jsonObject);
		Object errorCode = jsonObject.get("errcode");
		if (errorCode != null) {
			logger.info("redirectUri不合法");
			return null;
		} else {
			String openId = jsonObject.getString("openid");
			logger.info("openId:" + openId);
			return openId;
		}
	}

	/***
	 * 获取jsapiTicket 来源 www.vxzsk.com
	 * 
	 * @return
	 */
	public static String getJSApiTicket(String appId,String appSecret) {
		String ticketKey = "jsApiTicket_"+appId;
		String ticketTimeKey = "jsApiTicketTime_"+appId;
		if(checkJSApiTicket(ticketKey,ticketTimeKey)){
			logger.info("getJSApiTicket 开始获取jsapiTicket");
			// 获取token
			String acess_token = JsapiTicketUtil.getAccessToken( appId, appSecret);
			logger.info("获取acess_token：{}",acess_token);
			String urlStr = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi",
					acess_token);
			String backData = AcessToken.sendGet(urlStr, "utf-8", 10000);
			String ticket = (String) JSONObject.fromObject(backData).get("ticket");
			logger.info("获取ticket：{}",ticket);
			jsapiTicketMap.put(ticketKey,ticket);
			jsapiTicketMap.put(ticketTimeKey,System.currentTimeMillis());
		}
		return jsapiTicketMap.get(ticketKey).toString();

	}

	private static boolean checkJSApiTicket(String ticketKey ,String ticketTimeKey) {
		
		logger.info("checkJSApiTicket:{}",jsapiTicketMap.get(ticketKey));
		if (jsapiTicketMap.get(ticketKey) == null
				|| StringUtils.isBlank((String.valueOf(jsapiTicketMap.get(ticketKey))))
				|| jsapiTicketMap.get(ticketTimeKey) == null) {
			return true;
		}
		
		long time = Long.valueOf(jsapiTicketMap.get(ticketTimeKey).toString()) ;
		if(System.currentTimeMillis() - time > timeLimit){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		String jsapiTicket = JsapiTicketUtil.getJSApiTicket(Configure.getAppid(),Configure.getAppSecret());
		System.out.println("调用微信jsapi的凭证票为：" + jsapiTicket);
	}
}
