package com.chuangbu.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/view/register/")
public class ViewRegisterController {

	@RequestMapping(value = "/docter/{deptcode}/{deptname}")
	public String docterBydept(HttpServletRequest request	,@PathVariable String deptcode,@PathVariable String deptname) {
		request.setAttribute("deptCode", deptcode);
		request.setAttribute("deptName", deptname);
		return "/register/registerdocter";
	}
	@RequestMapping(value = "/info/{doctorname}/{deptname}/{charge}/{doctorCode}/{deptCode}")
	public String info(HttpServletRequest request	,@PathVariable String doctorname,@PathVariable String deptname,@PathVariable String charge,@PathVariable String doctorCode,@PathVariable String deptCode) {
		request.setAttribute("doctorName", doctorname);
		request.setAttribute("deptName", deptname);
		request.setAttribute("charge", charge);
		request.setAttribute("doctorCode", doctorCode);
		request.setAttribute("deptCode", deptCode);
		
		return "/register/registerinfo";
	}

}
