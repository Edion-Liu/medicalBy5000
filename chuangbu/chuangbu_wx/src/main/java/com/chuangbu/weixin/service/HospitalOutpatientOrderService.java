package com.chuangbu.weixin.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.util.HttpRequestUtils;
import com.chuangbu.common.util.RpcUtil;
import com.chuangbu.core.orm.hospital.domain.OutpatientOrder;
import com.chuangbu.core.orm.hospital.domain.RegisterOrder;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.service.hospital.OutpatientOrderService;
import com.chuangbu.weixin.constants.Constants;

import net.sf.json.JSONObject;

/**
 *  说 明 : 医院門診接口服务
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年6月11日 下午4:44:18
 */

@Service
public class HospitalOutpatientOrderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalOutpatientOrderService.class);
	
	private final String REG_RES_STS_OK = "ok";
	
	
	@Autowired
	OutpatientOrderService outpatientOrderService;
	

	public String createOrder(TAppConfig conf,String outpatientNo, String certificateNo, String prescNoAll, String charge, String wxOrderId) {
		LOGGER.info("调用接口开始:{}",conf.getRpcUrl());
		String url = String.format(Constants.RPC_MZSFSERVICE_OUTPATIENT_ORDER_URL,conf.getRpcUrl(),RpcUtil.getToken(Constants.RPC_KEY),outpatientNo,certificateNo, prescNoAll, charge,wxOrderId);
		return HttpRequestUtils.httpPost(url, null);
	}


	public boolean getOutpatientOrderPayData(TAppConfig conf,OutpatientOrder order, String outTradeNo, String transactionId) {
		outTradeNo = order.getOutTradeNo();
		String url = String.format(Constants.RPC_MZSFSERVICE_OUTPATIENT_ORDER_CONFIRM_URL, conf.getRpcUrl(), RpcUtil.getToken(Constants.RPC_KEY),order.getOutpatientNo(),order.getCertificateNo(),order.getPrescNo(),order.getTotalFee(),transactionId);
		String reresult = HttpRequestUtils.httpPost(url, null);
		if (StringUtils.isBlank(reresult)) {
			LOGGER.error("调用医疗接口--确认订单--错误！");
			return false;
		}

		JSONObject json = JSONObject.fromObject(reresult);
		String retStatus = json.get("status").toString();
		LOGGER.info("获取医疗状态：{}", retStatus);
		if (REG_RES_STS_OK.equals(retStatus)) {
			String data = String.valueOf(json.get("data"));
			if (StringUtils.isNotBlank(data)) {
				JSONObject jsonData = JSONObject.fromObject(data);
				if("0000".equals(((JSONObject)jsonData.get("Header")).get("ReturnCode").toString())){
					LOGGER.info("获取医疗订单流水号：{}", json.get("msg"));
				}else {
					LOGGER.warn("调用医疗接口--确认订单--返回信息异常{}", ((JSONObject)jsonData.get("Header")).get("ReturnMessage").toString());
					return false;
				}
			}else{
				LOGGER.error("调用医疗接口--确认订单--返回信息异常--返回数据为空");
				return false;
			}
		} else {
			LOGGER.error("调用医疗接口--确认订单--返回信息异常", json.get("msg"));
			return false;
		}
		// 修改订单状态
		String data = String.valueOf(json.get("data"));
		if (StringUtils.isNotBlank(data)) {
			JSONObject jsonData = JSONObject.fromObject(data);
			JSONObject jsonBody = jsonData.getJSONObject("Body");
			String outpatientNo = String.valueOf(jsonBody.get("OutpatientNo"));
			outpatientOrderService.updateOrderStatus(outTradeNo, transactionId, RegisterOrder.ORDER_SUCCESS,outpatientNo,order.getId());
		} else {
			LOGGER.info("获取医疗订单返回数据缺失！！");
		}
		
		return true;
	}

}
