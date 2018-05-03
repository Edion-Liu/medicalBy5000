package com.chuangbu.weixin.web;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**   
* @Title: WebLogAspect.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年1月21日 下午4:59:40 
* @version V1.0   
*/
@Aspect
@Component
public class WebLogAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.chuangbu.weixin.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
      
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        
        
//			HttpSession session = request.getSession(false);
//	        if (session == null) {
//	        	session = request.getSession(true);
//	        }
//
//	        String appId = request.getParameter("appId");
//            if(StringUtils.isBlank(appId)){
//            	appId = (String) session.getAttribute("appId");
//        		if(StringUtils.isBlank(appId)){
//            	 HttpServletResponse response = attributes.getResponse();
//                 response.sendRedirect("404");
//        		}else{
//        			session.setAttribute("appId", appId);
//        		}
//            }else{
//	          	 session.setAttribute("appId", appId);
//	        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
