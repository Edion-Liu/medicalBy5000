package com.chuangbu.rpc.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/outpatient/")
public class OutpatientController extends AdstractController {

	private Logger LOGGER = LoggerFactory.getLogger(OutpatientController.class);

	private static final String outpatientQuery = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0300</DealType>").append("    <DealCode>100301</DealCode>")
			.append("    <Body>").append("        <OutpatientNo>%s</OutpatientNo> <CertificateNo>%s</CertificateNo>")
			.append("    </Body>").append("</Request>").toString();

	private static final String outpatientOrder = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0300</DealType>").append("    <DealCode>100302</DealCode>")
			.append("    <Body>")
			.append(" <OutpatientNo>%s</OutpatientNo> <CertificateNo>%s</CertificateNo> <PrescNo>%s</PrescNo> <Money>%s</Money> <WeiXinOrderNo>%s</WeiXinOrderNo>")
			.append("    </Body>").append("</Request>").toString();

	private static final String outpatientOrderConfirm = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0300</DealType>").append("    <DealCode>100303</DealCode>")
			.append("    <Body>")
			.append(" <OutpatientNo>%s</OutpatientNo> <CertificateNo>%s</CertificateNo> <PrescNo>%s</PrescNo> <Money>%s</Money> <WeiXinOrderNo>%s</WeiXinOrderNo>")
			.append("    </Body>").append("</Request>").toString();

	@Value("${chuangbu.webservice.url:null}")
	private String url;

	@RequestMapping(value = "/mzsfService/query", method = RequestMethod.POST)
	public String query(@RequestParam("token") String token, @RequestParam("outpatientNo") String outpatientNo,
			@RequestParam("certificateNo") String certificateNo) {
		LOGGER.info("调用门诊查询服务开始");
		if (validateToken(token) && (StringUtils.isNotBlank(outpatientNo) || StringUtils.isNotBlank(certificateNo))) {
			String query = String.format(outpatientQuery, outpatientNo, certificateNo);
			Client.setUrl(url);
			String result = Client.mzsfService(query);
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

	@RequestMapping(value = "/mzsfService/order", method = RequestMethod.POST)
	public String order(@RequestParam("token") String token, @RequestParam("outpatientNo") String outpatientNo,
			@RequestParam("certificateNo") String certificateNo, @RequestParam("prescNoAll") String prescNoAll,
			@RequestParam("charge") String charge, @RequestParam("wxOrderId") String wxOrderId) {
		LOGGER.info("调用门诊订单服务开始");
		if (validateToken(token) && (StringUtils.isNotBlank(outpatientNo) || StringUtils.isNotBlank(certificateNo))) {
			String order = String.format(outpatientOrder, outpatientNo, certificateNo, prescNoAll, charge, wxOrderId);
			Client.setUrl(url);
			String result = Client.mzsfService(order);
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

	@RequestMapping(value = "/mzsfService/orderConfirm", method = RequestMethod.POST)
	public String orderConfirm(@RequestParam("token") String token, @RequestParam("outpatientNo") String outpatientNo,
			@RequestParam("certificateNo") String certificateNo, @RequestParam("prescNoAll") String prescNoAll,
			@RequestParam("charge") String charge, @RequestParam("wxOrderId") String wxOrderId) {
		LOGGER.info("调用门诊订单确认服务开始");
		if (validateToken(token) && (StringUtils.isNotBlank(outpatientNo) || StringUtils.isNotBlank(certificateNo))) {
			String order = String.format(outpatientOrderConfirm, outpatientNo, certificateNo, prescNoAll, charge, wxOrderId);
			Client.setUrl(url);
			String result = Client.mzsfService(order);
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

}
