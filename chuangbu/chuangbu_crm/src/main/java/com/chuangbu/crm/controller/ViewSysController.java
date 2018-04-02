package com.chuangbu.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/view/")
public class ViewSysController {

	@RequestMapping(value = "/sysDict/list")
	public String synopsis(HttpServletRequest request) {
		return "system/dict/dictType";
	}
	
	@RequestMapping(value = "/ssUser/list")
	public String userList(HttpServletRequest request) {
		return "system/user/userList";
	}
}
