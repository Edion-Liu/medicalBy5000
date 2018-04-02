package com.chuangbu.crm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**   
 * @Description: session监控
 * @author 361cjx@163.com   
 * @date 2016年9月4日 下午6:04:13 
 * @version V1.0   
 */
@WebListener
public class OnlineListener implements HttpSessionListener {  
  
    public void sessionCreated(HttpSessionEvent event) {  
        System.out.println("新建session:" + event.getSession().getId());  
    }  
  
    public void sessionDestroyed(HttpSessionEvent event) {  
       /* HttpSession session = event.getSession();  
        ServletContext application = session.getServletContext();  
        // 取得登录的用户名  
        String username = (String) session.getAttribute("username");  
        // 从在线列表中删除用户名  
        List onlineUserList = (List) application.getAttribute("onlineUserList");  
        onlineUserList.remove(username);  
        System.out.println(username+"已经退出！");  */
    	 System.out.println("注销session:" + event.getSession().getId());  
    }  
}  