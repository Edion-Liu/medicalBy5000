package com.chuangbu.weixin.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: MainsiteErrorController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年1月21日 下午5:29:25
 * @version V1.0
 */
@Controller
public class MainsiteErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		return "404";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}
}
