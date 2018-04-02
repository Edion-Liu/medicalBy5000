package com.chuangbu.weixin.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.common.exception.MyRuntimeException;
import com.chuangbu.common.util.HttpRequestUtils;
import com.chuangbu.common.util.RandomGUID;
import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.core.orm.hospital.domain.OutpatientOrder;
import com.chuangbu.core.orm.hospital.domain.RegisterOrder;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.service.hospital.OutpatientOrderService;
import com.chuangbu.core.service.hospital.RegisterOrderService;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.pay.tencent.bean.PagePayResult;
import com.chuangbu.pay.tencent.common.JsapiTicketUtil;
import com.chuangbu.pay.tencent.common.Sign;
import com.chuangbu.pay.tencent.common.Signature;
import com.chuangbu.pay.tencent.utils.PayCommonUtil;
import com.chuangbu.pay.tencent.utils.XMLUtil;
import com.chuangbu.weixin.constants.Constants;
import com.chuangbu.weixin.service.HospitalOutpatientOrderService;
import com.chuangbu.weixin.service.HospitalRegisterOrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/view/pay/")
public class ViewPayController extends AdstractController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewPayController.class);
	private final String REG_RES_STS_OK = "ok";

	@Autowired
    private TAppConfigService tAppConfigService;

	@Autowired
	RegisterOrderService registerOrderService;
	@Autowired
	HospitalRegisterOrderService hospitalRegisterOrderService;
	@Autowired
	OutpatientOrderService outpatientOrderService;
	@Autowired
	HospitalOutpatientOrderService hospitalOutpatientOrderService;

	/**
	 * 挂号订单提交
	 * 
	 */

	@RequestMapping(value = "/order/list")
	public String findOrderList() {

		return "/pay/orderList";
	}
	
	@RequestMapping(value = "/outpatient/order/list")
	public String findOutpatientOrderList() {
		
		return "/outpatient/outpatientOrderList";
	}

	@RequestMapping(value = "/wxJsAPI/registerSeccess")
	public String paySeccess(HttpServletRequest request, @RequestParam("outTradeNo") String outTradeNo) {
		RegisterOrder po = registerOrderService.findByOutTradeNo(getAppId(request),outTradeNo);
		request.setAttribute("orderInfo", JSONObject.fromObject(po));

		return "/pay/registerPay";

	}

	@RequestMapping(value = "/wxJsAPI/register")
	public String info(HttpServletRequest request, @RequestParam("docterName") String docterName,
			@RequestParam("deptName") String deptName, @RequestParam("charge") String charge,
			@RequestParam("doctorCode") String doctorCode, @RequestParam("deptCode") String deptCode) {
		request.setAttribute("doctorName", docterName);
		request.setAttribute("deptName", deptName);
		request.setAttribute("charge", charge);
		request.setAttribute("doctorCode", doctorCode);
		request.setAttribute("deptCode", deptCode);

		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		// 1、获取配置信息
		Map<String, String> signmap = getSign(request,conf);
		String timestamp = signmap.get("timestamp");
		String nonceStr = signmap.get("nonceStr");
		String signature = signmap.get("signature");
		request.setAttribute("appId", conf.getAppId());
		request.setAttribute("timestamp", timestamp);
		request.setAttribute("signature", signature);
		request.setAttribute("nonceStr", nonceStr);

		return "/register/registerinfo";
	}

	/**
	 * 患者挂号订单
	 * 
	 * @param request
	 * @param CardID
	 * @param CustomerName
	 * @param Sex
	 * @param Birthday
	 * @param CertificateNo
	 * @param PhoneCode
	 * @param PhoneCodeContact
	 * @param deptCode
	 * @param doctorCode
	 * @param deptName
	 * @param doctorName
	 * @param charge
	 * @param spBillCreateIP
	 * @param openId
	 * @param timestamp
	 * @param nonceStr
	 * @return
	 */
	@RequestMapping(value = "/wxJsAPI/registerCreatOrder")
	@ResponseBody
	public Map<String, String> registerCreatOrder(HttpServletRequest request, @RequestParam("CardID") String CardID,
			@RequestParam("CustomerName") String CustomerName, @RequestParam("Sex") String Sex,
			@RequestParam("Birthday") String Birthday, @RequestParam("CertificateNo") String CertificateNo,
			@RequestParam("PhoneCode") String PhoneCode, @RequestParam("PhoneCodeContact") String PhoneCodeContact,
			@RequestParam("deptCode") String deptCode, @RequestParam("doctorCode") String doctorCode,
			@RequestParam("deptName") String deptName, @RequestParam("doctorName") String doctorName,
			@RequestParam("charge") String charge, @RequestParam("spBillCreateIP") String spBillCreateIP,
			@RequestParam("openId") String openId, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonceStr") String nonceStr) {

		if (StringUtils.isBlank("openId")) {
			LOGGER.error("openId为空！！");
			FAIL.put("msg", "openId为空");
			return FAIL;
		}
		LOGGER.info("用户生成订单开始。。。。。。。openId为{}", openId);
		
		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		if("wx6586b8dd160b6eb4".equals(conf.getAppId())){
			charge = "0.5";
		}else if("wxa317cc2d1887a4bc".equals(conf.getAppId())){
			
		}else{
			charge = "0.01";
		}
		// 1、生成医疗订单订单
		Map<String, String> remap = hospitalRegisterOrderService.createOrder(conf.getRpcUrl(),CardID, CustomerName, Sex, Birthday,
				CertificateNo, PhoneCode, PhoneCodeContact, deptCode, doctorCode, charge);
		if (!REG_RES_STS_OK.equals(remap.get("status").toString())) {
			FAIL.put("msg", remap.get("msg").toString());
			return FAIL;
		}

		// 3、生成微信订单
		PagePayResult payResult;
		String body = String.format("患者【%s】挂科室【%s】医生【%s】就诊号", CustomerName, deptName, doctorName);
		String outTradeNo = String.format("%s_%s", remap.get("MedicareNo").toString(),
				remap.get("ChargeNo").toString());
		try {
			String notifyUrl = request.getRequestURL().toString();
			notifyUrl = notifyUrl.substring(0, notifyUrl.indexOf("/wxJsAPI")) + "/wxJsAPI/registerPayNotify";
			payResult = hospitalRegisterOrderService.createWXOrder(conf,notifyUrl, charge, spBillCreateIP, openId,
					outTradeNo, body);
		} catch (MyRuntimeException e) {
			LOGGER.error("生成微信订单失败", e);
			FAIL.put("msg", e.getMessage());
			return FAIL;
		}

		// 3、本地保存数据
		registerOrderService.saveOrderInfo(CardID, CustomerName, CertificateNo, PhoneCode, deptCode, doctorCode, charge,
				spBillCreateIP, openId, outTradeNo, body, payResult.getPrepay_id(), conf.getAppId(),
				conf.getMehId(), deptName, doctorName);

		// 4获取订单签名信息
		String p_package = "prepay_id=" + payResult.getPrepay_id();
		Map<String, Object> paymap = new HashMap<String, Object>();
		paymap.put("appId", conf.getAppId());
		paymap.put("timeStamp", timestamp);
		paymap.put("nonceStr", nonceStr);
		paymap.put("package", p_package);
		paymap.put("signType", "MD5");
		String paysignature = Signature.getSign(paymap,conf.getAppKey());

		SECCESS.put("prepayId", p_package);
		SECCESS.put("paysignature", paysignature);
		SECCESS.put("outTradeNo", outTradeNo);

		return SECCESS;

	}

	@RequestMapping(value = "/wxJsAPI/registerPayNotify", method = RequestMethod.POST)
	public void payNotify(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("支付成功--payNotify");

		try {
			InputStream inStream = request.getInputStream();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			inStream.close();
			String result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息
			LOGGER.info("支付通知信息：{}", result);
			Map<String, Object> map = XMLUtil.doXMLParse(result);

			if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
				TAppConfig conf = tAppConfigService.getTAppConfig(map.get("appid").toString());
				if (verifyWeixinNotify(map,conf.getAppKey())) {
					String outTradeNo = map.get("out_trade_no").toString();
					String MedicareNo = outTradeNo.split("_")[0];
					String ChargeNo = outTradeNo.split("_")[1];
					String transactionId = map.get("transaction_id").toString();
					
					RegisterOrder ro = new RegisterOrder();
					ro.setAppid(conf.getAppId());
					ro.setOutTradeNo(outTradeNo);
					ro.setTransactionId(transactionId);
					ro.setStatus(RegisterOrder.ORDER_SUCCESS);
					List<RegisterOrder> ros= registerOrderService.find(ro);
					if(ros == null || ros.size()<1){
					
						// 确认医院订单
						String payxml = hospitalRegisterOrderService.getRegisterOrderPayData(MedicareNo, ChargeNo,
								transactionId);
						String url = String.format(Constants.RPC_MZGHSERVICE_PAY_URL, conf.getRpcUrl(), getToken(),
								Des3Util.encode(payxml));
						String reresult = HttpRequestUtils.httpPost(url, null);
						if (StringUtils.isBlank(reresult)) {
							LOGGER.error("调用医疗接口--确认订单--错误！");
							return;
						}
	
						JSONObject json = JSONObject.fromObject(reresult);
						String retStatus = json.get("status").toString();
						LOGGER.info("获取医疗状态：{}", retStatus);
						if (REG_RES_STS_OK.equals(retStatus)) {
							LOGGER.info("获取医疗订单流水号：{}", json.get("msg"));
						} else {
							LOGGER.error("调用医疗接口--确认订单--返回信息异常", json.get("msg"));
							return;
						}
	
						// 修改订单状态
						String data = String.valueOf(json.get("data"));
						if (StringUtils.isNotBlank(data)) {
							JSONObject jsonData = JSONObject.fromObject(data);
							JSONObject jsonBody = jsonData.getJSONObject("Body");
							String outpatientNo = String.valueOf(jsonBody.get("OutpatientNo"));
							String serialNo = String.valueOf(jsonBody.get("SerialNo"));
							String indexNo = String.valueOf(jsonBody.get("VisitNo"));
							String deptPosition = String.valueOf(jsonBody.get("Position"));
							String visitDate = String.valueOf(jsonBody.get("VisitDate"));
							registerOrderService.updateOrderStatus(outTradeNo, transactionId, RegisterOrder.ORDER_SUCCESS,
									outpatientNo, serialNo, indexNo, deptPosition, visitDate,conf.getAppId());
						} else {
							LOGGER.info("获取医疗订单返回数据缺失！！");
						}
					}else{
						LOGGER.info("订单已经处理过，只需通知微信即可！");
					}
					// 订单处理
					String resultxml = new PagePayResult("SUCCESS", "OK").getXML();
					LOGGER.info("告诉微信服务器，收到消息，并已经处理：{}", resultxml);
					response.getWriter().write(resultxml); // 告诉微信服务器，我收到信息了，不要在调用回调action了
				}
			}
		} catch (IOException | JDOMException e) {
			LOGGER.error("解析支付通知异常", e);
		}

	}

	public boolean verifyWeixinNotify(Map<String, Object> map,String appKey) {
		SortedMap<String, String> parameterMap = new TreeMap<String, String>();
		String sign = (String) map.get("sign");
		for (Object keyValue : map.keySet()) {
			if (!keyValue.toString().equals("sign")) {
				parameterMap.put(keyValue.toString(), (String) map.get(keyValue));
			}
		}
		String createSign = PayCommonUtil.createSign("UTF-8", parameterMap,appKey);
		if (createSign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取签名信息
	 * 
	 * @param request
	 * @param conf2 
	 * @return
	 */
	public Map<String, String> getSign(HttpServletRequest request, TAppConfig conf) {
		String url = request.getRequestURL().toString();// .append("?").append(request.getQueryString().toString()).toString();
		if (request.getQueryString() != null) {
			url = request.getRequestURL().append("?").append(request.getQueryString().toString()).toString();
		} else {
			url = request.getRequestURL().toString();
		}

		LOGGER.info("获取签名辅助信息开始=======wxJSAPI====================url={}", url);
		String jsapi_ticket = JsapiTicketUtil.getJSApiTicket(conf.getAppId(),conf.getAppsecret());
		LOGGER.info("获取签名辅助信息结束=======wxJSAPI====================jsapi_ticket={}", jsapi_ticket);
		Map<String, String> map = Sign.sign(jsapi_ticket, url);
		return map;
	}

	/**
	 * 门诊订单信息
	 * 
	 */

	@RequestMapping(value = "/wxJsAPI/outpatient")
	public String info(HttpServletRequest request) {

		// 1、获取配置信息
		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		Map<String, String> signmap = getSign(request,conf);
		String timestamp = signmap.get("timestamp");
		String nonceStr = signmap.get("nonceStr");
		String signature = signmap.get("signature");
		request.setAttribute("appId", conf.getAppId());
		request.setAttribute("timestamp", timestamp);
		request.setAttribute("signature", signature);
		request.setAttribute("nonceStr", nonceStr);

		return "/outpatient/outpatientPay";
	}

	@RequestMapping(value = "/wxJsAPI/outpatientCreatOrder")
	@ResponseBody
	public Map<String, String> outpatientCreatOrder(HttpServletRequest request,
			@RequestParam("OutpatientNo") String OutpatientNo, @RequestParam("CertificateNo") String CertificateNo,
			@RequestParam("prescNoAll") String prescNoAll, @RequestParam("charge") String charge,
			@RequestParam("CustomerName") String CustomerName, @RequestParam("DoctorName") String DoctorName,
			@RequestParam("DeptName") String DeptName, @RequestParam("SerialNo") String SerialNo,
			@RequestParam("spBillCreateIP") String spBillCreateIP, @RequestParam("openId") String openId,
			@RequestParam("timestamp") String timestamp, @RequestParam("nonceStr") String nonceStr) {

		if (StringUtils.isBlank("openId")) {
			LOGGER.error("openId为空！！");
			FAIL.put("msg", "openId为空");
			return FAIL;
		}
		LOGGER.info("用户生成订单开始。。。。。。。openId为{}", openId);
		charge = "0.01";

		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		/*if("wx6586b8dd160b6eb4".equals(conf.getAppId())){
			charge = "0.5";
		}*/
		
		String outTradeNo = null ;
		// 1、生成医疗订单订单
		String reresult = hospitalOutpatientOrderService.createOrder(conf,OutpatientNo, CertificateNo, prescNoAll, charge,null);
		JSONObject json = JSONObject.fromObject(reresult);
		LOGGER.info("生成医疗订单订单状态：{}", json.get("status"));
		if (!REG_RES_STS_OK.equals(json.get("status"))) {
			FAIL.put("msg", json.get("msg").toString());
			return FAIL;
		}else{
			String data = String.valueOf(json.get("data"));
			if (StringUtils.isNotBlank(data)) {
				JSONObject jsonData = JSONObject.fromObject(data);
				if("0000".equals(jsonData.getJSONObject("Header").get("ReturnCode").toString())){
					LOGGER.info("获取医疗订单流水号：{}", json.get("msg"));
					String body = jsonData.get("Body").toString();
					LOGGER.info("获取医疗订单流水号：{}", body);
					if(body.indexOf("List")>0 && body.indexOf("List")<5){
						JSONObject jsonlist = jsonData.getJSONObject("Body").getJSONObject("List");
						outTradeNo = jsonlist.get("MedicareNo").toString();
					}else{
						JSONArray jarr = jsonData.getJSONArray("Body");
						Iterator<Object> it = jarr.iterator();
						while (it.hasNext()) {
						JSONObject ob = (JSONObject) it.next();
						String medicareNo = ob.get("MedicareNo").toString();
							if(StringUtils.isNotBlank(outTradeNo)){
								outTradeNo = StringUtils.isNotBlank(medicareNo) ? outTradeNo +"_"+ medicareNo : outTradeNo;
							}else{
								outTradeNo = medicareNo;
							}
						}
					}
				}else {
					String msg = ((JSONObject)jsonData.get("Header")).get("ReturnMessage").toString();
					LOGGER.warn("调用医疗接口--确认订单--返回信息异常{}", msg);
					FAIL.put("msg", msg);
					return FAIL;
				}
			}else{
				FAIL.put("msg", json.get("msg").toString());
				return FAIL;
			}
		}
		
		
		OutpatientOrder order = outpatientOrderService.findByOutTradeNo(conf.getAppId(), outTradeNo);
		if(order != null && (RegisterOrder.ORDER_SUCCESS.equals(order.getStatus()) || RegisterOrder.ORDER_TO_BE_CONFIRMED.equals(order.getStatus()))){
			FAIL.put("msg", "该订单已经支付完成，请勿重复提交!");
			return FAIL;
		}
		boolean flag = false;
		String orderId= null;
		if(order == null){
			orderId = RandomGUID.getGUID();
			flag = true;
		}else{
			orderId = order.getId();
		}

		// 2、生成微信订单
		PagePayResult payResult;
		String body = String.format("门诊缴费￥%s成功", charge);
		try {
			String notifyUrl = request.getRequestURL().toString();
			notifyUrl = notifyUrl.substring(0, notifyUrl.indexOf("/wxJsAPI")) + "/wxJsAPI/outpatientPayNotify";
			payResult = hospitalRegisterOrderService.createWXOrder(conf,notifyUrl, charge, spBillCreateIP, openId,
					orderId, body);
		} catch (MyRuntimeException e) {
			LOGGER.error("生成微信订单失败", e);
			FAIL.put("msg", e.getMessage());
			return FAIL;
		}
		LOGGER.info("本地保存数据开始");
		// 3、本地保存数据
		outpatientOrderService.saveOrderInfo(orderId,OutpatientNo, CertificateNo, charge,spBillCreateIP, openId, outTradeNo,
				body, payResult.getPrepay_id(), conf.getAppId(), conf.getMehId(), prescNoAll, SerialNo,CustomerName,DoctorName,DeptName,flag);
		LOGGER.info("本地保存数据结束");
		// 4获取订单签名信息
		String p_package = "prepay_id=" + payResult.getPrepay_id();
		Map<String, Object> paymap = new HashMap<String, Object>();
		paymap.put("appId", conf.getAppId());
		paymap.put("timeStamp", timestamp);
		paymap.put("nonceStr", nonceStr);
		paymap.put("package", p_package);
		paymap.put("signType", "MD5");
		String paysignature = Signature.getSign(paymap,conf.getAppKey());

		SECCESS.put("prepayId", p_package);
		SECCESS.put("paysignature", paysignature);
		SECCESS.put("outTradeNo", outTradeNo);

		return SECCESS;

	}

	@RequestMapping(value = "/wxJsAPI/outpatientPayNotify", method = RequestMethod.POST)
	public void outpatientPayNotify(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("门诊支付成功--payNotify");

		try {
			InputStream inStream = request.getInputStream();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			inStream.close();
			String result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息
			LOGGER.info("支付通知信息：{}", result);
			Map<String, Object> map = XMLUtil.doXMLParse(result);

			if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
				TAppConfig conf = tAppConfigService.getTAppConfig(map.get("appid").toString());
				if (verifyWeixinNotify(map,conf.getAppKey())) {
					String outTradeNo = map.get("out_trade_no").toString();
					String transactionId = map.get("transaction_id").toString();
					//由于长度问题，微信返回的外部编码其实是，本地订单表的主键；需要进行转换
					OutpatientOrder order = outpatientOrderService.findOne(outTradeNo);
					if(!OutpatientOrder.ORDER_SUCCESS.equals(order.getStatus())){
						//先修改订单状态，用于确认订单已经付款成功
						outpatientOrderService.updateOrderStatus(null, transactionId, OutpatientOrder.ORDER_TO_BE_CONFIRMED,null,outTradeNo);
						// 确认医院订单
						if (!hospitalOutpatientOrderService.getOutpatientOrderPayData(conf,order,outTradeNo, transactionId)) {
							LOGGER.error("调用医疗接口--确认订单--错误！");
							return;
						}
					}

					// 订单处理
					String resultxml = new PagePayResult("SUCCESS", "OK").getXML();
					LOGGER.info("告诉微信服务器，收到消息，并已经处理：{}", resultxml);
					response.getWriter().write(resultxml); // 告诉微信服务器，我收到信息了，不要在调用回调action了
				}
			}
		} catch (IOException | JDOMException e) {
			LOGGER.error("解析支付通知异常", e);
		}

	}
	
	@RequestMapping(value = "/wxJsAPI/outpatientSeccess")
	public String outpatientPaySeccess(HttpServletRequest request, @RequestParam("outTradeNo") String outTradeNo) {
		OutpatientOrder po = outpatientOrderService.findByOutTradeNo(getAppId(request),outTradeNo);
		request.setAttribute("orderInfo", JSONObject.fromObject(po));

		return "/pay/outpatientSeccess";

	}
	
}
