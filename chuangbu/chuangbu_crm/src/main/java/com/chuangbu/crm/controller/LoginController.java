package com.chuangbu.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chuangbu.crm.shiro.service.UsernamePasswordCaptchaToken;

/**   
* @Title: LoginController.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年1月3日 下午6:06:50 
* @version V1.0   
*/
@Controller
public class LoginController {

	static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, String userName, String password, String captcha,
			HttpServletResponse response, Model model) {
		try {
			System.out.println("-----login------------------");
			if (StringUtils.isBlank(userName)) {
				return new ModelAndView("login");
			}
			System.out.println("-----开始校验------------------");
			Subject currentUser = SecurityUtils.getSubject();
			boolean rememberMe = false;
			String host = request.getRequestURI();
			UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(userName, password.toCharArray(),
					rememberMe, host, captcha);
			currentUser.login(token);
			/** Shiro验证后,跳转到此处,这里判断验证是否通过 */
			if (currentUser.isAuthenticated()) { // 验证身份通过
				return new ModelAndView("redirect:/view/main");
			} else {
				return new ModelAndView("login");
			}
		} catch (UnknownAccountException e) {
			String msg = "对用户[" + userName + "]进行登录验证..验证未通过";
			logger.error(msg);
			model.addAttribute(msg);
		} catch (IncorrectCredentialsException e) {
			String msg = "对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证";
			logger.error(msg);
			model.addAttribute(msg);
		} catch (LockedAccountException e) {
			String msg = "对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定";
			logger.error(msg);
			model.addAttribute(msg);
		} catch (ExcessiveAttemptsException e) {
			String msg = "对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多";
			logger.error(msg);
			model.addAttribute(msg);
		} catch (AuthenticationException e) {
			String msg = "对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下";
			logger.error(msg,e);
			model.addAttribute(msg);
		}
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
}
