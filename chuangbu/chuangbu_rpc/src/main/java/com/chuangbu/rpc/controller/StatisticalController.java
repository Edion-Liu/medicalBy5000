package com.chuangbu.rpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuangbu.rpc.service.StatisticalService;

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
@RequestMapping(value = "/statistical/")
public class StatisticalController extends AdstractController {

	@Autowired
	StatisticalService statisticalService;
	
	@RequestMapping(value="/global/data",method = RequestMethod.POST)
    public String pageData(@RequestParam("token") String token){
		if(validateToken(token)){
			JSONObject obj = new JSONObject();
			obj.put("incomeData",JSONArray.fromObject(statisticalService.getIncomeData()));
			obj.put("inoutData",JSONArray.fromObject(statisticalService.getInoutData()));
			obj.put("weekIncomeData",JSONArray.fromObject(statisticalService.getWeekIncomeData()));
			SECCESS.put("data", obj.toString());
			return JSONObject.fromObject(SECCESS).toString();
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}
    }

	
}
