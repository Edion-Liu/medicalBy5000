package com.test.rpc;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年3月18日 下午5:58:49
 */

public class AsmxTest {
	static Logger log = LoggerFactory.getLogger(AsmxTest.class);
	String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
			+"<Request>"
			+"    <DealType>0200</DealType>"
			+"    <DealCode>100206</DealCode>"
			+"    <Body>"
			+"        <DeptCode>20101</DeptCode>"
			+"    </Body>"
			+"</Request>";
	
	String url="http://1643yt6280.imwork.net:12611/hisservice/Service.asmx";//提供接口的地址
	String soapaction="http://tempuri.org/";   //域名，这是在server定义的
	String op = "MzghService";
	String para = "request";
	
	public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
	/*
		Service service = new Service();
//		String url = "http://xxxxx.xx.xx/yy.asmx";
		//在浏览器中打开url，可以找到SOAPAction: "http://www.chinsoft.com.cn/SendMQ"
//		String namespace = "http://tempuri.org";
		String actionUri = "MzghService"; //Action路径
		String op = "MzghService"; //要调用的方法名
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL(url));
//		call.setUsername("your username"); // 用户名（如果需要验证）
//		call.setPassword("your password"); // 密码
		call.setUseSOAPAction(true);
		call.setSOAPActionURI(soapaction + actionUri); // action uri
//		call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
		// 设置参数名称，具体参照从浏览器中看到的
		call.addParameter(new QName(soapaction, "request"), XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING); // 要返回的数据类型
		Object[] params = new Object[] {request};
		String result = (String) call.invoke(params); //方法执行后的返回值
		System.out.println(result);*/
		
		/*Service service=new Service();
        try{
            Call call=(Call)service.createCall();            
            call.setTargetEndpointAddress(url);            
            call.setOperationName(new QName(soapaction,op)); //设置要调用哪个方法
            call.addParameter(new QName(soapaction,para), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                   javax.xml.rpc.ParameterMode.IN);
//            call.setReturnType(new QName(soapaction,"DoTest"),String.class); //要返回的数据类型（自定义类型）
           
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//（标准的类型）
           
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + op);    
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");     
            String str=(String)call.invoke(new Object[]{request});//调用方法并传递参数        
            System.out.println(str);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");     
           
        }catch(Exception ex)
        {
        ex.printStackTrace();
        }  */ 
		
		new AsmxTest().test1();
	}
	
	private void test1(){  
		try 
		  { 
		String a = "a"; 
		 // 创建一个服务(service)调用(call)     
      Service service = new Service();    
      Call call = (Call) service.createCall();// 通过service创建call对象     
      // 设置service所在URL    
      call.setTargetEndpointAddress(new java.net.URL(url));   

      call.setOperationName(new QName(soapaction,op)); 
      //Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
     call.addParameter(new QName(soapaction,para),
             org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
     // 这就是我搞了一天的原因所在,"test" 这个就是传参数的变量,也就是NET方面的参数,一定不要带错了
      // 我当初不知道 ,以为这个参数是自己随便写的,结果总是报NULL,真是气死人了
      
      call.setUseSOAPAction(true); 
      call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); //返回参数的类型
      call.setSOAPActionURI(soapaction+op); //这个也要注意 就是要加上要调用的方法Add,不然也会报错
      
      // Object 数组封装了参数，参数为"This is Test!",调用processService(String arg)     
      String ret = (String) call.invoke(new Object[] {a});    
      System.out.println("--------"+ret); 
		  }catch(Exception ex) 
		  { 
			  log.error("@@@",ex); 
//		  return new GeneralResult(new Integer(-1), "调用开户接口时产生异常!"); 
		  } 
	}
	private void getMobileCodeInfo(){  
        try {  
                final String SERVER_URL = "http://1643yt6280.imwork.net:12611/HisService/Service.asmx/MzghService"; // 定义需要获取的内容来源地址  
                HttpPost request = new HttpPost(SERVER_URL);    
                List<BasicNameValuePair> params = new ArrayList();  
                params.add(new BasicNameValuePair("request", "136370628"));  //（注意这里的号码必须大于6位）  
//                params.add(new BasicNameValuePair("userId", ""));   
                request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));   
                HttpResponse httpResponse = new DefaultHttpClient().execute(request);    
                if (httpResponse.getStatusLine().getStatusCode() != 404)  
                {  
                        String result = EntityUtils.toString(httpResponse.getEntity());  
                        System.out.println(result);   
                }  
        } catch (Exception e) {  
        	log.error("eee",e);  
        }  
}  
}
