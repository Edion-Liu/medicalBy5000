package com.chuangbu.rpc.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年4月7日 下午10:37:11
 */

public class Client {

	private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "Service");
	
	private static Service ss;
	
	
	/**
	 * 设置访问地址
	 * @param wsdl
	 */
	public static void setUrl(String wsdl){
		if(ss == null){
			URL url = null;
	        try {
	            url = new URL(wsdl);
	        } catch (MalformedURLException e) {
	            java.util.logging.Logger.getLogger(Service.class.getName())
	                .log(java.util.logging.Level.INFO, 
	                     "Can not initialize the default wsdl from {0}", wsdl);
	        }
	        ss = new Service(url, SERVICE_NAME);
		}
	}
	
	public static String mzghService(String str){
		ServiceSoap port = ss.getServiceSoap();  
		return port.mzghService(str);
	}
	
	public static String mzsfService(String str){
		ServiceSoap port = ss.getServiceSoap();  
		return port.mzsfService(str);
	}
}
