package com.test.rpc;

import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;  

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年3月18日 下午7:16:06
 */

public class PutWeather {
	 private String url="http://1643yt6280.imwork.net:12611/hisservice/Service.asmx";//提供接口的地址
     private String soapaction="http://microsoft.com/webservices/";   //域名，这是在server定义的
    
     public PutWeather()
     {
         String City="北京";        
         Service service=new Service();
         try{
             Call call=(Call)service.createCall();            
             call.setTargetEndpointAddress(url);            
             call.setOperationName(new QName(soapaction,"getWeatherbyCityName")); //设置要调用哪个方法
             call.addParameter(new QName(soapaction,"theCityName"), //设置要传递的参数
                     org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
             call.setReturnType(new QName(soapaction,"getWeatherbyCityName"),Vector.class); //要返回的数据类型（自定义类型）
            
//             call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//（标准的类型）
            
             call.setUseSOAPAction(true);
             call.setSOAPActionURI(soapaction + "getWeatherbyCityName");    
                        
             Vector v=(Vector)call.invoke(new Object[]{City});//调用方法并传递参数        
             for(int i=0;i<v.size();i++)
             {
                 System.out.println(v.get(i));
             }            
            
         }catch(Exception ex)
         {
         ex.printStackTrace();
         }        
     }
    
     public static void main(String args[])
     {
         PutWeather pw=new PutWeather();
     }
}
