package com.chuangbu.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/view/console/")
public class ViewConsoleController {

	@RequestMapping(value = "/")
	public String office() {

		return "console";
	}

}
