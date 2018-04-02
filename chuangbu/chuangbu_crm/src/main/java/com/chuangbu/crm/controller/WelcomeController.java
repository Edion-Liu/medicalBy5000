package com.chuangbu.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {

	@RequestMapping(value = "/")
	public String home(HttpServletRequest request) {
		/*Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			return "redirect:/main";
		} else {
			return "login";
		}*/
		return "main";
	}

	@RequestMapping(value = "/main")
	public String index(HttpServletRequest request) {
		return "main";
	}
	
}
