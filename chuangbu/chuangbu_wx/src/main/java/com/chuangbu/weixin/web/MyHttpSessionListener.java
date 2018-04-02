package com.chuangbu.weixin.web;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chuangbu.pay.tencent.common.Configure;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年8月24日 下午9:41:09
 */

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    	LOGGER.info("一個 Session 被创建");
//    	se.getSession().setAttribute("appId", Configure.getAppid());
        ServletContext context = se.getSession().getServletContext();  
        if (context.getAttribute("count")==null) {  
        	context.setAttribute("count", 0);  
        }else {  
	        int count = (Integer) context.getAttribute("count");  
	        context.setAttribute("count", count+1);  
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	LOGGER.info(" 一個 Session 被註銷");
        ServletContext context = se.getSession().getServletContext();  
        if (context.getAttribute("count")==null) {  
        	context.setAttribute("count", 0);  
        }else {  
        int count = (Integer) context.getAttribute("count");  
	        if (count<1) {  
	        count = 1;  
        }  
        context.setAttribute("count", count-1);  
        }  
        HttpSession session = se.getSession();  
        String name = (String) session.getAttribute("name");  
        HashSet<String> nameSet = (HashSet<String>) context.getAttribute("nameSet");  
        if(nameSet != null){
        	nameSet.remove(name);  
        }
    }

}
