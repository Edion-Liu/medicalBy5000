package com.chuangbu.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/view/")
public class ViewController {

	@RequestMapping(value = "/main")
	public String synopsis(HttpServletRequest request) {
		return "/main";
	}
	
	
}
