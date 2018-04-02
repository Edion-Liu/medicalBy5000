package com.test.rpc;

import com.chuangbu.common.util.des3.Des3Util;

/**   
* @Title: RpcDemoTest.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午12:13:52 
* @version V1.0   
*/
public class RpcDemoTest {
	
	public static void main(String[] args) {
		/*String url = "http://localhost:8090/home";
		System.out.println(HttpRequestUtils.httpPost(url, null));*/
		/*String token = Des3Util.encode("CHUANGBU_RPC");
		String url = "http://localhost:8090/drug/pageData?token="+token+"&pageSize=10&pageIndex=1&drugName=11";
		JSONObject json = new JSONObject();	
		json.put("pageSize", "12");
		json.put("pageIndex", "1");
		json.put("drugName", "11");
		System.out.println(HttpRequestUtils.httpPost(url, null));*/
		System.out.println(Des3Util.encode("manager"));
	}
	
}
