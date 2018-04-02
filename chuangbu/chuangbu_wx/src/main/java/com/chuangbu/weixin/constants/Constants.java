package com.chuangbu.weixin.constants;

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

	public static final String RPC_MZGHSERVICE_DEPT_URL = "http://%s/register/mzghService/dept?token=%s";
	public static final String RPC_MZGHSERVICE_DOCTER_URL = "http://%s/register/mzghService/docter?token=%s&deptCode=%s";
	public static final String RPC_MZGHSERVICE_PER_URL = "http://%s/register/mzghService/per?token=%s&codeNo=%s";
	public static final String RPC_MZGHSERVICE_ORDER_URL = "http://%s/register/mzghService/order?token=%s&order=%s";
	public static final String RPC_MZGHSERVICE_PAY_URL = "http://%s/register/mzghService/pay?token=%s&pay=%s";

	public static final String RPC_MZSFSERVICE_OUTPATIENT_QUERY_URL = "http://%s/outpatient/mzsfService/query?token=%s&outpatientNo=%s&certificateNo=%s";
	public static final String RPC_MZSFSERVICE_OUTPATIENT_ORDER_URL = "http://%s/outpatient/mzsfService/order?token=%s&outpatientNo=%s&certificateNo=%s&prescNoAll=%s&charge=%s&wxOrderId=%s";
	public static final String RPC_MZSFSERVICE_OUTPATIENT_ORDER_CONFIRM_URL = "http://%s/outpatient/mzsfService/orderConfirm?token=%s&outpatientNo=%s&certificateNo=%s&prescNoAll=%s&charge=%s&wxOrderId=%s";

}
