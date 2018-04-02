package com.chuangbu.weixin.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chuangbu.common.exception.MyRuntimeException;
import com.chuangbu.common.util.Arith;
import com.chuangbu.common.util.DateUtil;
import com.chuangbu.common.util.HttpRequestUtils;
import com.chuangbu.common.util.RpcUtil;
import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.pay.tencent.bean.PagePayReqData;
import com.chuangbu.pay.tencent.bean.PagePayResult;
import com.chuangbu.pay.tencent.common.Configure;
import com.chuangbu.pay.tencent.common.Signature;
import com.chuangbu.weixin.constants.Constants;
import com.chuangbu.weixin.register.bean.OrderInfo;
import com.chuangbu.weixin.register.bean.OrderPayInfo;
import com.chuangbu.weixin.register.bean.Request;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

import net.sf.json.JSONObject;

/**
 *  说 明 : 医院接口服务
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年6月11日 下午4:44:18
 */

@Service
public class HospitalRegisterOrderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalRegisterOrderService.class);
	
	private final String REG_RES_STS_OK = "ok";
	private final String PAY_RES_SUCCESS = "SUCCESS";

	
	public Map<String,String> createOrder(String rpcUrl,String CardID, String CustomerName, String Sex, String Birthday,
			String CertificateNo, String PhoneCode, String PhoneCodeContact, String DeptCode, String DoctorCode,
			String charge){
		Map<String,String> reMap = new HashMap<String,String>();
		
		String reorderxml = getRegisterOrderData(CardID, CustomerName, Sex, Birthday, CertificateNo, PhoneCode,
				PhoneCodeContact, DeptCode, DoctorCode, charge);

		String url = String.format(Constants.RPC_MZGHSERVICE_ORDER_URL, rpcUrl, RpcUtil.getToken(Constants.RPC_KEY),
				Des3Util.encode(reorderxml));
		String reresult = HttpRequestUtils.httpPost(url, null);
		if (StringUtils.isBlank(reresult)) {
			LOGGER.error("调用医疗接口--生成订单--错误！");
			reMap.put("status", "no");
			reMap.put("msg", "生成订单--错误");
			return reMap;
		}

		JSONObject json = JSONObject.fromObject(reresult);
		LOGGER.info("获取医疗状态：{}", json.get("status"));
		if (REG_RES_STS_OK.equals(json.get("status"))) {
			JSONObject jsonData = JSONObject.fromObject(json.get("data"));
			String ChargeNo = (String) jsonData.getJSONObject("Body").get("ChargeNo");
			String MedicareNo = (String) jsonData.getJSONObject("Body").get("MedicareNo");
			LOGGER.info("获取医疗订单流水号：{}", ChargeNo);
			reMap.put("status", REG_RES_STS_OK);
			reMap.put("msg", "生成订单--成功");
			reMap.put("ChargeNo", ChargeNo);
			reMap.put("MedicareNo", MedicareNo);
			return reMap;
		} else {
			LOGGER.error("调用医疗接口--生成订单--返回信息异常", json.get("msg"));
			reMap.put("status", "no");
			reMap.put("msg", json.get("msg").toString());
			return reMap;
		}
	}
	
	private String getRegisterOrderData(String CardID, String CustomerName, String Sex, String Birthday,
			String CertificateNo, String PhoneCode, String PhoneCodeContact, String DeptCode, String DoctorCode,
			String charge) {
		OrderInfo order = new OrderInfo();
		order.setDeptCode(DeptCode);
		order.setDoctorCode(DoctorCode);
		order.setVisitDate(DateUtil.getStringDateShort().replace("-", ""));
		order.setVisitTime(DateUtil.getTimeShort());
		order.setVisitFlag("1");
		order.setVisitType("3");
		order.setSumFee(charge);
		order.setPatientType("1");

		Request req = new Request();
		req.setDealType("0200");
		req.setDealCode("100201");
		req.setCardID(CardID);
		req.setCustomerName(CustomerName);
		req.setSex(Sex);
		req.setBirthday(Birthday);
		req.setCertificateNo(CertificateNo);
		req.setPhoneCode(PhoneCode);
		req.setPhoneCodeContact(PhoneCodeContact);

		req.setBody(order);

		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.aliasSystemAttribute(null, "class");

		return xstream.toXML(req);
	}

	public PagePayResult createWXOrder(TAppConfig conf,String notifyUrl, String charge, String spBillCreateIP, String openId,
			String outTradeNo, String body) {
		String orderxml = getWXOrderData(conf,notifyUrl, body, outTradeNo, charge, spBillCreateIP,
				openId);
		LOGGER.info("wxJSAPI====================orderxml={}", orderxml);
		String result = HttpRequestUtils.httpPost(Configure.PAY_PAGE_API, null, orderxml);
		LOGGER.info("result:{}" , result);

		XStream xstream = new XStream(new XppDriver());
		xstream.alias("xml", PagePayResult.class);// 为类名节点重命名
		PagePayResult payResult = (PagePayResult) xstream.fromXML(result);
		if (!(PAY_RES_SUCCESS.equals(payResult.getReturn_code())
				&& PAY_RES_SUCCESS.equals(payResult.getResult_code()))) {
			throw new MyRuntimeException("调用微信支付接口失败！");
		}
		LOGGER.info("调用微信订单接口成功；Return_code:{}", payResult.getReturn_code());
		return payResult;
	}

	private String getWXOrderData(TAppConfig conf,String notifyUrl, String body, String outTradeNo, String charge,
			String spBillCreateIP, String openId) {

		double total = Arith.mul(Double.valueOf(charge), 100d);
		int totalFee = (int) total;
		PagePayReqData payData = new PagePayReqData(conf.getAppId(),conf.getMehId(),body, outTradeNo, totalFee, spBillCreateIP, notifyUrl, openId);

		try {
			payData.setSign(Signature.getSign(payData,conf.getAppKey()));
		} catch (IllegalAccessException e) {
			LOGGER.error("签名失败!", e);
		}
		XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		xstream.autodetectAnnotations(true);
		String orderxml = xstream.toXML(payData);
		return orderxml;
	}

	public String getRegisterOrderPayData(String medicareNo, String chargeNo, String netchargeID) {
		OrderPayInfo pay = new OrderPayInfo();
		pay.setMedicareNo(medicareNo);
		pay.setNetchargeID(netchargeID);
		pay.setChargeNo(chargeNo);
		
		Request req = new Request();
		req.setDealType("0200");
		req.setDealCode("100202");
		
		req.setBody(pay);
		
		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.aliasSystemAttribute(null, "class");
		
		return xstream.toXML(req);
	}

}
