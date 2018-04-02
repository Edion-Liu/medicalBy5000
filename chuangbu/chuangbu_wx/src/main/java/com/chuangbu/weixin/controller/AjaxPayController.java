package com.chuangbu.weixin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.core.orm.hospital.domain.OutpatientOrder;
import com.chuangbu.core.orm.hospital.domain.RegisterOrder;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.service.hospital.OutpatientOrderService;
import com.chuangbu.core.service.hospital.RegisterOrderService;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.pay.tencent.common.JsapiTicketUtil;
import com.chuangbu.weixin.service.HospitalRegisterOrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/ajax/pay/tencent/")
public class AjaxPayController extends AdstractController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AjaxPayController.class);


	@Autowired
	HospitalRegisterOrderService hospitalRegisterOrderService;

	@Autowired
	RegisterOrderService registerOrderService;
	@Autowired
	OutpatientOrderService outpatientOrderService;
	
	@Autowired
    private TAppConfigService tAppConfigService;

	@RequestMapping(value = "/getOrderData")
	@ResponseBody
	public String getOrderData(HttpServletRequest request, @RequestParam("openId") String openId){
		if(StringUtils.isNotBlank(openId)){
			
			try {
				RegisterOrder ro = new RegisterOrder();
				ro.setOpenid(openId);
				ro.setAppid(getAppId(request));
				ro.setStatus(RegisterOrder.ORDER_SUCCESS);
				ro.setOrderByCT("ct desc");
				List<RegisterOrder> ros= registerOrderService.find(ro);
				SECCESS.put("data", JSONArray.fromObject(ros).toString());
				return JSONObject.fromObject(SECCESS).toString();
			} catch (Exception e) {
				LOGGER.error("获取订单异常",e);
				return JSONObject.fromObject(FAIL).toString();
			}
			
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}	
	}
	
	@RequestMapping(value = "/getOutpatientOrderData")
	@ResponseBody
	public String getOutpatientOrderData(HttpServletRequest request, @RequestParam("openId") String openId){
		if(StringUtils.isNotBlank(openId)){
			
			try {
				OutpatientOrder ro = new OutpatientOrder();
				ro.setOpenid(openId);
				ro.setAppid(getAppId(request));
				ro.setStatus(OutpatientOrder.ORDER_SUCCESS);
				ro.setOrderByCT("ct desc");
				List<OutpatientOrder> ros= outpatientOrderService.find(ro);
				SECCESS.put("data", JSONArray.fromObject(ros).toString());
				return JSONObject.fromObject(SECCESS).toString();
			} catch (Exception e) {
				LOGGER.error("获取订单异常",e);
				return JSONObject.fromObject(FAIL).toString();
			}
			
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}	
	}
	
	
	@RequestMapping(value = "/getOpenId")
	@ResponseBody
	public String getOpenId(HttpSession httpSession,HttpServletRequest request,@RequestParam("code") String code) {
		
		if(StringUtils.isNotBlank(code)){
			
			try {
				LOGGER.info("获取openId======code={}",code);
				TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
	            String openId =JsapiTicketUtil.getOpenId(code,conf.getAppId(),conf.getAppsecret());
	            LOGGER.info("获取openId开始==================openId={}",openId);
	            httpSession.setAttribute("openId", openId);
				SECCESS.put("data", openId);
				return JSONObject.fromObject(SECCESS).toString();
			} catch (Exception e) {
				LOGGER.error("获取openId异常",e);
				return JSONObject.fromObject(FAIL).toString();
			}
			
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	
	/**
	 * 获取用户当天成功挂号次数
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/getOpenIdDayRegisterCount")
	@ResponseBody
	public String getOpenIdDayRegisterCount(HttpServletRequest request, @RequestParam("openId") String openId){
		if(StringUtils.isNotBlank(openId)){
			
			try {
				TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
				RegisterOrder ro = new RegisterOrder();
				ro.setOpenid(openId);
				ro.setAppid(conf.getAppId());
				ro.setStatus(RegisterOrder.ORDER_SUCCESS);
				ro.setAppid(conf.getAppId());
				int count = registerOrderService.findByOpenIdAndDayCount(ro);
				SECCESS.put("data", String.format("{\"count\":%s}", count));
				return JSONObject.fromObject(SECCESS).toString();
			} catch (Exception e) {
				LOGGER.error("获取用户当天成功挂号次数异常",e);
				return JSONObject.fromObject(FAIL).toString();
			}
			
		}else{
			return JSONObject.fromObject(FAIL).toString();
		}	
	}
	
}
