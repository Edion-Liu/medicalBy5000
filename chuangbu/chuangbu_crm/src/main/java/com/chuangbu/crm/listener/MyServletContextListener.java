package com.chuangbu.crm.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuangbu.core.orm.sys.domain.SsPermission;
import com.chuangbu.core.orm.sys.mapper.SsPermissionMapper;

/**   
 * @Description: 使用@WebListener注解，实现ServletContextListener接口
 * @author 361cjx@163.com   
 * @date 2016年7月31日 下午8:12:13 
 * @version V1.0   
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

	@Autowired
	SsPermissionMapper ssPermissionMapper;
	
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	try {
    		logger.info("ServletContex初始化");
        	logger.info(sce.getServletContext().getServerInfo());
            
        	List<SsPermission> menus = ssPermissionMapper.findMenuAll();
            
            logger.info("sys parameters size:{}" , menus.size());

            sce.getServletContext().setAttribute("menus", menus);
		} catch (Exception e) {
			logger.error("初始化失败：",e);
		}
    	
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContex销毁");
    }

}