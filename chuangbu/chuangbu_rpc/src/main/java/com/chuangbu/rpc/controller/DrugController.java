package com.chuangbu.rpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuangbu.rpc.service.DrugService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**   
* @Title: DrugController.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午5:37:28 
* @version V1.0   
*/
@RestController
@RequestMapping(value = "/drug/")
public class DrugController extends AdstractController {

	@Autowired
	DrugService drugService;
	
	@RequestMapping(value="/pageData",method = RequestMethod.POST)
    public String pageData(@RequestParam("token") String token,@RequestParam("pageSize") String pageSize,
			@RequestParam("pageIndex") String pageIndex, @RequestParam("generalName") String generalName){
		if(validateToken(token)){
			JSONArray arvert = JSONArray.fromObject(drugService.findByGeneralName(generalName));  
			SECCESS.put("data", arvert.toString());
			return JSONObject.fromObject(SECCESS).toString();
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}
    }

	
}
