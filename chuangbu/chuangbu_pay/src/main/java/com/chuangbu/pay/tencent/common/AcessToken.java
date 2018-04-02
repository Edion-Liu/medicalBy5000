package com.chuangbu.pay.tencent.common;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;
/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月1日 下午10:11:56
 */

public class AcessToken {

	/*** V型知识库 www.vxzsk.com 
     * 模拟get请求 
     * @param url 
     * @param charset 
     * @param timeout 
     * @return 
     */  
     public static String sendGet(String url, String charset, int timeout)  
      {  
        String result = "";  
        try  
        {  
          URL u = new URL(url);  
          try  
          {  
            URLConnection conn = u.openConnection();  
            conn.connect();  
            conn.setConnectTimeout(timeout);  
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));  
            String line="";  
            while ((line = in.readLine()) != null)  
            {  
               
              result = result + line;  
            }  
            in.close();  
          } catch (IOException e) {  
            return result;  
          }  
        }  
        catch (MalformedURLException e)  
        {  
          return result;  
        }  
         
        return result;  
      }  
   
       
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        String appid="wx75c2579a3a58d745";//应用ID  
        String appSecret="6f85cfaa124535adb981ff8bcf28546a";//(应用密钥)  
        String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appSecret+"";  
        String backData=AcessToken.sendGet(url, "utf-8", 10000);  
        System.out.println("返回："+backData);  
    }  
}
