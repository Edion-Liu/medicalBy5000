package com.chuangbu.rpc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/test/")
public class WelcomeController {

	@Value("${chuangbu.webservice.url:null}")
	private String url;
	
	@RequestMapping(value="/")
	public String home(HttpServletRequest request) {
		return "get 请求成功 ;url:"+url;
	}
	
}
