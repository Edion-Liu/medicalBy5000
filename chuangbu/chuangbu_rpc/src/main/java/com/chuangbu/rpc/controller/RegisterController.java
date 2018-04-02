package com.chuangbu.rpc.controller;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.rpc.client.Client;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * @Title: DrugController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月2日 下午5:37:28
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/register/")
public class RegisterController extends AdstractController {
	
	private Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	private final String REG_RES_STS_OK = "100";

	private static final String deptInp = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0200</DealType>").append("    <DealCode>100204</DealCode>")
			.append("    <Body>").append("        <SpecialType>-1</SpecialType>").append("    </Body>")
			.append("</Request>").toString();
	
	private static final String docterInp = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0200</DealType>").append("    <DealCode>100206</DealCode>")
			.append("    <Body>").append("        <DeptCode>%s</DeptCode>").append("    </Body>")
			.append("</Request>").toString();
	
	private static final String perInp = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0200</DealType>").append("    <DealCode>100207</DealCode>")
			.append("    <Body>").append("    <CertificateType>CARDNO</CertificateType>    <CertificateNo>%s</CertificateNo>").append("    </Body>")
			.append("</Request>").toString();

	@Value("${chuangbu.webservice.url:null}")
	private String url;

	@RequestMapping(value = "/mzghService/dept", method = RequestMethod.POST)
	public String dept(@RequestParam("token") String token) {
		LOGGER.info("调用科室服务开始");
		if (validateToken(token)) {
			 Client.setUrl(url);
			String result = Client.mzghService(deptInp);
			if (StringUtils.isNotBlank(result)) {
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(result);
				SECCESS.put("data", json.toString());
				return JSONObject.fromObject(SECCESS).toString();
			} else {
				return JSONObject.fromObject(FAIL).toString();
			}
		} else {
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	
	@RequestMapping(value = "/mzghService/docter", method = RequestMethod.POST)
	public String docterByDept(@RequestParam("token") String token,@RequestParam("deptCode") String deptCode) {
		LOGGER.info("调用科室医生服务开始：{}",deptCode);
		if (validateToken(token) && StringUtils.isNotBlank(deptCode)) {
			String docterStr = String.format(docterInp, deptCode);
			Client.setUrl(url);
			String result = Client.mzghService(docterStr);
			if (StringUtils.isNotBlank(result)) {
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(result);
				SECCESS.put("data", json.toString());
				return JSONObject.fromObject(SECCESS).toString();
			} else {
				return JSONObject.fromObject(FAIL).toString();
			}
		} else {
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	
	@RequestMapping(value = "/mzghService/per", method = RequestMethod.POST)
	public String perByCard(@RequestParam("token") String token,@RequestParam("codeNo") String codeNo) {
		LOGGER.info("调用科室医生服务开始：{}",codeNo);
		if (validateToken(token) && StringUtils.isNotBlank(codeNo)) {
			String perStr = String.format(perInp, codeNo);
			Client.setUrl(url);
			String result = Client.mzghService(perStr);
			if (StringUtils.isNotBlank(result)) {
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(result);
				SECCESS.put("data", json.toString());
				return JSONObject.fromObject(SECCESS).toString();
			} else {
				return JSONObject.fromObject(FAIL).toString();
			}
		} else {
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	
	@RequestMapping(value = "/mzghService/order", method = RequestMethod.POST)
	public String order(@RequestParam("token") String token,@RequestParam("order") String order) {
		
		if (validateToken(token) && StringUtils.isNotBlank(order)) {
			order = order.replace(" ", "+");
			order = Des3Util.decode(order);
			LOGGER.info("挂号订单信息：{}",order);
			Client.setUrl(url);
			String result = Client.mzghService(order);
			LOGGER.info("挂号订单返回结果：{}",result);
			if (StringUtils.isNotBlank(result)) {
				try {
					Document document = DocumentHelper.parseText(result);
					Element root = document.getRootElement();
					Element hele = root.element("Header");
					Element code = hele.element("ReturnCode");
					if (!REG_RES_STS_OK.equals(code.getText())) {
						LOGGER.error("调用医疗接口--生成订单--失败，原因：{}",hele.element("ReturnMessage").getText());
						FAIL.put("msg", hele.element("ReturnMessage").getText());
						return JSONObject.fromObject(FAIL).toString();
					}			
				} catch (DocumentException e) {
					LOGGER.error("调用医疗接口--生成订单--返回信息异常",e);
					FAIL.put("msg", "调用医疗接口--生成订单--返回信息异常");
					return JSONObject.fromObject(FAIL).toString();
				}
				
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(result);
				SECCESS.put("data", json.toString());
				return JSONObject.fromObject(SECCESS).toString();
			} else {
				return JSONObject.fromObject(FAIL).toString();
			}
		} else {
			return JSONObject.fromObject(FAIL).toString();
		}
	}
	
	@RequestMapping(value = "/mzghService/pay", method = RequestMethod.POST)
	public String pay(@RequestParam("token") String token,@RequestParam("pay") String pay) {
		
		if (validateToken(token) && StringUtils.isNotBlank(pay)) {
			pay = pay.replace(" ", "+");
			pay = Des3Util.decode(pay);
			LOGGER.info("确认支付信息：{}",pay);
			Client.setUrl(url);
			String result = Client.mzghService(pay);
			LOGGER.info("挂号订单返回结果：{}",result);
			if (StringUtils.isNotBlank(result)) {
				try {
					Document document = DocumentHelper.parseText(result);
					Element root = document.getRootElement();
					Element hele = root.element("Header");
					Element code = hele.element("ReturnCode");
					if (!REG_RES_STS_OK.equals(code.getText())) {
						LOGGER.error("调用医疗接口--确认订单--失败，原因：{}",hele.element("ReturnMessage").getText());
						FAIL.put("msg", hele.element("ReturnMessage").getText());
						return JSONObject.fromObject(FAIL).toString();
					}			
				} catch (DocumentException e) {
					LOGGER.error("调用医疗接口--确认订单--返回信息异常",e);
					FAIL.put("msg", "调用医疗接口--确认订单--返回信息异常");
					return JSONObject.fromObject(FAIL).toString();
				}
				
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(result);
				SECCESS.put("data", json.toString());
				return JSONObject.fromObject(SECCESS).toString();
			} else {
				return JSONObject.fromObject(FAIL).toString();
			}
		} else {
			return JSONObject.fromObject(FAIL).toString();
		}
	}

}
