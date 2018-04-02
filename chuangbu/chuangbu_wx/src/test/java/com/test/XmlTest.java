package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.weixin.register.bean.Header;
import com.chuangbu.weixin.register.bean.OrderInfo;
import com.chuangbu.weixin.register.bean.OrderResultInfo;
import com.chuangbu.weixin.register.bean.Request;
import com.chuangbu.weixin.register.bean.Response;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月29日 下午8:36:32
 */

public class XmlTest {
	
	public static void main(String[] args) throws DocumentException {
		Header header = new Header();
		header.setReturnCode("100");
		header.setReturnMessage("挂号订单提交成功,请尽快完成支付!");
		
		OrderResultInfo ori = new OrderResultInfo();
		ori.setMedicareNo("20170422002667");
		ori.setChargeNo("1195014");
		ori.setRegisterFee("1");
		ori.setDiagnosticFee("3");
		ori.setSumFee("4");
		ori.setPrivatePay("3");
		ori.setMedicareAccountPay("0");
		ori.setPoolingAccountPay("0");
		ori.setDeliveryMessage("234234");
		
		Response res = new Response();
		res.setHeader(header);
		res.setBody(ori);
		
		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.aliasSystemAttribute(null, "class");
		
		String orderxml = xstream.toXML(res);
		System.out.println(orderxml);
		
//		xstream.alias("xml", PagePayResult.class);// 为类名节点重命名
//		Response rebean = (Response) xstream.fromXML(orderxml);
		
//		System.out.println(rebean.getHeader().getReturnCode());
		
		
		Document document = DocumentHelper.parseText(orderxml); 
		
//		1.获取文档的根节点.  
	      Element root = document.getRootElement();  
	      Element hele = root.element("Header");  
	      Element code = hele.element("ReturnCode");  
	      System.out.println(code.getText());
	        
	}

	@Test
	public void orderResultTest() throws DocumentException{
		Header header = new Header();
		header.setReturnCode("100");
		header.setReturnMessage("挂号订单提交成功,请尽快完成支付!");
		
		OrderResultInfo ori = new OrderResultInfo();
		ori.setMedicareNo("20170422002667");
		ori.setChargeNo("1195014");
		ori.setRegisterFee("1");
		ori.setDiagnosticFee("3");
		ori.setSumFee("4");
		ori.setPrivatePay("3");
		ori.setMedicareAccountPay("0");
		ori.setPoolingAccountPay("0");
		ori.setDeliveryMessage("234234");
		
		Response res = new Response();
		res.setHeader(header);
		res.setBody(ori);
		
		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.aliasSystemAttribute(null, "class");
		
		String orderxml = xstream.toXML(res);
		System.out.println(orderxml);
		
//		xstream.alias("xml", PagePayResult.class);// 为类名节点重命名
//		Response rebean = (Response) xstream.fromXML(orderxml);
		
//		System.out.println(rebean.getHeader().getReturnCode());
		
	
	}
	
	//@Test
	public void orderTest(){
		OrderInfo order = new OrderInfo();
		order.setDeptCode("20119");
		order.setDoctorCode("0701001");
		order.setVisitDate("20180101");
		order.setVisitTime("23:23:59");
		order.setVisitFlag("1");
		order.setVisitType("3");
		order.setSumFee("15");
		order.setPatientType("1");
		
		Request req = new Request();
		req.setDealType("0200");
		req.setDealCode("100201");
		req.setCardID("00028412");
		req.setCustomerName("迎春");
		req.setSex("女");
		req.setBirthday("20170101");
		req.setCertificateNo("152323199908083588");
		req.setPhoneCode("14784543444");
		req.setPhoneCodeContact("14784543444");
		
		req.setBody(order);
		
		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.aliasSystemAttribute(null, "class");
		
		String orderxml = xstream.toXML(req);
		System.out.println(orderxml);
		
		String exml = Des3Util.encode(orderxml);
		System.out.println(exml);
		System.out.println(Des3Util.decode(exml));
	}
	
}
