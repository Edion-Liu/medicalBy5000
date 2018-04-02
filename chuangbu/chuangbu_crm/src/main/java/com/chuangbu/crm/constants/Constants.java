package com.chuangbu.crm.constants;

/**   
* @Title: WeiXinConstants.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月3日 下午12:41:06 
* @version V1.0   
*/
public class Constants {
	
	public static final String RPC_KEY = "CHUANGBU_RPC";
	
	public static final String RPC_DRUG_URL = "http://%s/drug/pageData?token=%s&pageSize=%s&pageIndex=%s&generalName=%s";
	public static final String RPC_TREATMENT_URL = "http://%s/treatment/pageData?token=%s&pageSize=%s&pageIndex=%s&generalName=%s";
	
	public static final String RPC_STATISTICAL_GLOBAL_URL = "http://%s/statistical/global/data?token=%s";
}
