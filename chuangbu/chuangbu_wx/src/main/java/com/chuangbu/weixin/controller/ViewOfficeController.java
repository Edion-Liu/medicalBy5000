package com.chuangbu.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/view/office/")
public class ViewOfficeController {

	@RequestMapping(value = "/office")
	public String office() {

		return "office/office";
	}
	@RequestMapping(value = "/report")
	public String officeReport() {
		return "office/report/report";
	}

	@RequestMapping(value = "/reporttest")
	public String reporttest() {
		return "office/report/test";
	}


	@RequestMapping(value = "/followup")
	public String officeFollowUp() {
		return "office/follow-up/follow-up";
	}





}
