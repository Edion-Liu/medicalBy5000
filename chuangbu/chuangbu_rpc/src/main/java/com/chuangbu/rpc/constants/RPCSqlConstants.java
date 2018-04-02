package com.chuangbu.rpc.constants;

/**   
* @Title: RPCSqlConstants.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月3日 下午12:36:46 
* @version V1.0   
*/
public class RPCSqlConstants {

	//药品目录查询
	public static final String QUERY_DRUG_All = "select code,generalName,tradeName,spec from dic_drug ";
	public static final String QUERY_DRUG = "select code,generalName,tradeName,spec from dic_drug where generalName like ? ";
	//诊疗目录查询
	public static final String QUERY_TREATMENT_ALL = "select code,generalName,tradeName,spec from dic_chargestandard ";
	public static final String QUERY_TREATMENT = "select code,generalName,tradeName,spec from dic_chargestandard ";
	
}
