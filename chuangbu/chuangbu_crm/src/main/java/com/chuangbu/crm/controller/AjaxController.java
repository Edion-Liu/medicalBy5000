package com.chuangbu.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.core.orm.sys.domain.SsPermission;
import com.chuangbu.core.orm.sys.mapper.SsPermissionMapper;


@Controller
@RequestMapping(value = "/ajax")
public class AjaxController extends AdstractController{
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	SsPermissionMapper ssPermissionMapper;

	@RequestMapping(value = "/menu")
	@ResponseBody
	public String date(HttpSession session) {
		System.out.println("@@@@@@@@@@@@");
		try {
			List<SsPermission> menus = ssPermissionMapper.findMenuAll();
			logger.info("sys parameters size:{}" , menus.size());
			
			session.setAttribute("menus", menus);
			
		} catch (Exception e) {
			logger.error("错误：",e);
		}
        
		return "";
	}
	@RequestMapping(value = "/drug/data")
	@ResponseBody
	public String drugData(@RequestParam("pageSize") String pageSize,
			@RequestParam("pageIndex") String pageIndex, @RequestParam("generalName") String generalName) {
		String result = null ;
		return result;
	}
	
}
