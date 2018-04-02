package com.chuangbu.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/view/office/")
public class ViewOfficeController {

	@RequestMapping(value = "/office")
	public String office() {

		System.out.println("%%%%%%%%%%%%%%%%%%");
		return "office/office";
	}

}
