package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.RegisterOrderPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_register_order Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-06-11 23:28:42
 */
public class RegisterOrder extends RegisterOrderPo implements Domain {

	public static final String ORDER_INIT = "00";
	public static final String ORDER_SUCCESS = "01";
	public static final String ORDER_FAIL = "02";
	public static final String ORDER_TO_BE_CONFIRMED = "03";
	
	private String orderByCT;
	
	
	public String getOrderByCT() {
		return orderByCT;
	}

	public void setOrderByCT(String orderByCT) {
		this.orderByCT = orderByCT;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void onSave(){
		//this.id=System.currentTimeMillis();
	}
	
	public String validate(){
		StringBuffer sb = new StringBuffer();
			
		if(this.getId() == null)
			sb.append("id不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getOrderNo().getBytes().length > 96)
			sb.append("订单宽度不能超过96个字符！");
			
		if(this.getPrepayId().getBytes().length > 192)
			sb.append("预支付交易会话标识宽度不能超过192个字符！");
			
		if(this.getAppid().getBytes().length > 96)
			sb.append("公众账号ID宽度不能超过96个字符！");
			
		if(this.getMchId().getBytes().length > 96)
			sb.append("商户号宽度不能超过96个字符！");
			
		if(this.getBody().getBytes().length > 384)
			sb.append("商品描述宽度不能超过384个字符！");
			
		if(this.getOutTradeNo().getBytes().length > 96)
			sb.append("商户订单号宽度不能超过96个字符！");
			
		if(this.getSpbillCreateIp().getBytes().length > 48)
			sb.append("终端IP宽度不能超过48个字符！");
			
		if(this.getOpenid().getBytes().length > 384)
			sb.append("用户标识宽度不能超过384个字符！");
			
		if(this.getStatus().getBytes().length > 6)
			sb.append("状态宽度不能超过6个字符！");
			
		if(this.getCardId().getBytes().length > 96)
			sb.append("就诊卡号宽度不能超过96个字符！");
			
		if(this.getCustomerName().getBytes().length > 60)
			sb.append("患者姓名宽度不能超过60个字符！");
			
		if(this.getCertificateNo().getBytes().length > 54)
			sb.append("身份证号宽度不能超过54个字符！");
			
		if(this.getPhoneCode().getBytes().length > 45)
			sb.append("病人电话宽度不能超过45个字符！");
			
		if(this.getDeptCode().getBytes().length > 30)
			sb.append("科室编码宽度不能超过30个字符！");
			
		if(this.getDeptName().getBytes().length > 150)
			sb.append("就诊科室名称宽度不能超过150个字符！");
			
		if(this.getDocterCode().getBytes().length > 30)
			sb.append("医生编码宽度不能超过30个字符！");
			
		if(this.getDoctorName().getBytes().length > 60)
			sb.append("就诊医生名称宽度不能超过60个字符！");
			
		if(this.getDeptPosition().getBytes().length > 150)
			sb.append("就诊科室位置宽度不能超过150个字符！");
			
		if(this.getTransactionId().getBytes().length > 96)
			sb.append("微信支付订单号宽度不能超过96个字符！");
			
		if(this.getOutpatientNo().getBytes().length > 96)
			sb.append("门诊号宽度不能超过96个字符！");
			
		if(this.getSerialNo().getBytes().length > 96)
			sb.append("流水号宽度不能超过96个字符！");
			
		if(this.getIndexNo().getBytes().length > 60)
			sb.append("就诊序号宽度不能超过60个字符！");
			
		if(this.getVisitDate().getBytes().length > 30)
			sb.append("就诊日期宽度不能超过30个字符！");
			
		String msg = sb.toString() ;
		if (msg.length() == 0)
			  return null ;

		return  msg;
	}
	
	/**
	 * dto 属性值put到map
	 */
	public Map<String,Object> getColumnsValueToMap(){
		Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",this.getId());
			map.put("orderno",this.getOrderNo());
			map.put("prepayid",this.getPrepayId());
			map.put("appid",this.getAppid());
			map.put("mchid",this.getMchId());
			map.put("body",this.getBody());
			map.put("outtradeno",this.getOutTradeNo());
			map.put("totalfee",this.getTotalFee());
			map.put("spbillcreateip",this.getSpbillCreateIp());
			map.put("openid",this.getOpenid());
			map.put("status",this.getStatus());
			map.put("cardid",this.getCardId());
			map.put("customername",this.getCustomerName());
			map.put("certificateno",this.getCertificateNo());
			map.put("phonecode",this.getPhoneCode());
			map.put("deptcode",this.getDeptCode());
			map.put("deptname",this.getDeptName());
			map.put("doctercode",this.getDocterCode());
			map.put("doctorname",this.getDoctorName());
			map.put("deptposition",this.getDeptPosition());
			map.put("ct",this.getCt());
			map.put("transactionid",this.getTransactionId());
			map.put("outpatientno",this.getOutpatientNo());
			map.put("serialno",this.getSerialNo());
			map.put("indexno",this.getIndexNo());
			map.put("visitdate",this.getVisitDate());
		return map;
	}
	
	/**
	 * map值  set到Domain 处理NULL值
	 */
	public void doMapToColumnValueNullValid(Map<String,Object> map){
		if(map.containsKey("id")){
			if(null==map.get("id")){
				this.setId(null);
			}else{
				this.setId((String)map.get("id"));
			}
		}
		if(map.containsKey("orderno")){
			if(null==map.get("orderno")){
				this.setOrderNo(null);
			}else{
				this.setOrderNo((String)map.get("orderno"));
			}
		}
		if(map.containsKey("prepayid")){
			if(null==map.get("prepayid")){
				this.setPrepayId(null);
			}else{
				this.setPrepayId((String)map.get("prepayid"));
			}
		}
		if(map.containsKey("appid")){
			if(null==map.get("appid")){
				this.setAppid(null);
			}else{
				this.setAppid((String)map.get("appid"));
			}
		}
		if(map.containsKey("mchid")){
			if(null==map.get("mchid")){
				this.setMchId(null);
			}else{
				this.setMchId((String)map.get("mchid"));
			}
		}
		if(map.containsKey("body")){
			if(null==map.get("body")){
				this.setBody(null);
			}else{
				this.setBody((String)map.get("body"));
			}
		}
		if(map.containsKey("outtradeno")){
			if(null==map.get("outtradeno")){
				this.setOutTradeNo(null);
			}else{
				this.setOutTradeNo((String)map.get("outtradeno"));
			}
		}
		if(map.containsKey("totalfee")){
			if(null==map.get("totalfee")){
				this.setTotalFee(null);
			}else{
				this.setTotalFee((Integer)map.get("totalfee"));
			}
		}
		if(map.containsKey("spbillcreateip")){
			if(null==map.get("spbillcreateip")){
				this.setSpbillCreateIp(null);
			}else{
				this.setSpbillCreateIp((String)map.get("spbillcreateip"));
			}
		}
		if(map.containsKey("openid")){
			if(null==map.get("openid")){
				this.setOpenid(null);
			}else{
				this.setOpenid((String)map.get("openid"));
			}
		}
		if(map.containsKey("status")){
			if(null==map.get("status")){
				this.setStatus(null);
			}else{
				this.setStatus((String)map.get("status"));
			}
		}
		if(map.containsKey("cardid")){
			if(null==map.get("cardid")){
				this.setCardId(null);
			}else{
				this.setCardId((String)map.get("cardid"));
			}
		}
		if(map.containsKey("customername")){
			if(null==map.get("customername")){
				this.setCustomerName(null);
			}else{
				this.setCustomerName((String)map.get("customername"));
			}
		}
		if(map.containsKey("certificateno")){
			if(null==map.get("certificateno")){
				this.setCertificateNo(null);
			}else{
				this.setCertificateNo((String)map.get("certificateno"));
			}
		}
		if(map.containsKey("phonecode")){
			if(null==map.get("phonecode")){
				this.setPhoneCode(null);
			}else{
				this.setPhoneCode((String)map.get("phonecode"));
			}
		}
		if(map.containsKey("deptcode")){
			if(null==map.get("deptcode")){
				this.setDeptCode(null);
			}else{
				this.setDeptCode((String)map.get("deptcode"));
			}
		}
		if(map.containsKey("deptname")){
			if(null==map.get("deptname")){
				this.setDeptName(null);
			}else{
				this.setDeptName((String)map.get("deptname"));
			}
		}
		if(map.containsKey("doctercode")){
			if(null==map.get("doctercode")){
				this.setDocterCode(null);
			}else{
				this.setDocterCode((String)map.get("doctercode"));
			}
		}
		if(map.containsKey("doctorname")){
			if(null==map.get("doctorname")){
				this.setDoctorName(null);
			}else{
				this.setDoctorName((String)map.get("doctorname"));
			}
		}
		if(map.containsKey("deptposition")){
			if(null==map.get("deptposition")){
				this.setDeptPosition(null);
			}else{
				this.setDeptPosition((String)map.get("deptposition"));
			}
		}
		if(map.containsKey("ct")){
			if(null==map.get("ct")){
				this.setCt(null);
			}else{
				this.setCt((Timestamp)map.get("ct"));
			}
		}
		if(map.containsKey("transactionid")){
			if(null==map.get("transactionid")){
				this.setTransactionId(null);
			}else{
				this.setTransactionId((String)map.get("transactionid"));
			}
		}
		if(map.containsKey("outpatientno")){
			if(null==map.get("outpatientno")){
				this.setOutpatientNo(null);
			}else{
				this.setOutpatientNo((String)map.get("outpatientno"));
			}
		}
		if(map.containsKey("serialno")){
			if(null==map.get("serialno")){
				this.setSerialNo(null);
			}else{
				this.setSerialNo((String)map.get("serialno"));
			}
		}
		if(map.containsKey("indexno")){
			if(null==map.get("indexno")){
				this.setIndexNo(null);
			}else{
				this.setIndexNo((String)map.get("indexno"));
			}
		}
		if(map.containsKey("visitdate")){
			if(null==map.get("visitdate")){
				this.setVisitDate(null);
			}else{
				this.setVisitDate((String)map.get("visitdate"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("RegisterOrderPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("orderNo").append(" = ").append(this.getOrderNo()).append(sep);
		sb.append("prepayId").append(" = ").append(this.getPrepayId()).append(sep);
		sb.append("appid").append(" = ").append(this.getAppid()).append(sep);
		sb.append("mchId").append(" = ").append(this.getMchId()).append(sep);
		sb.append("body").append(" = ").append(this.getBody()).append(sep);
		sb.append("outTradeNo").append(" = ").append(this.getOutTradeNo()).append(sep);
		sb.append("totalFee").append(" = ").append(this.getTotalFee()).append(sep);
		sb.append("spbillCreateIp").append(" = ").append(this.getSpbillCreateIp()).append(sep);
		sb.append("openid").append(" = ").append(this.getOpenid()).append(sep);
		sb.append("status").append(" = ").append(this.getStatus()).append(sep);
		sb.append("cardId").append(" = ").append(this.getCardId()).append(sep);
		sb.append("customerName").append(" = ").append(this.getCustomerName()).append(sep);
		sb.append("certificateNo").append(" = ").append(this.getCertificateNo()).append(sep);
		sb.append("phoneCode").append(" = ").append(this.getPhoneCode()).append(sep);
		sb.append("deptCode").append(" = ").append(this.getDeptCode()).append(sep);
		sb.append("deptName").append(" = ").append(this.getDeptName()).append(sep);
		sb.append("docterCode").append(" = ").append(this.getDocterCode()).append(sep);
		sb.append("doctorName").append(" = ").append(this.getDoctorName()).append(sep);
		sb.append("deptPosition").append(" = ").append(this.getDeptPosition()).append(sep);
		sb.append("ct").append(" = ").append(this.getCt()).append(sep);
		sb.append("transactionId").append(" = ").append(this.getTransactionId()).append(sep);
		sb.append("outpatientNo").append(" = ").append(this.getOutpatientNo()).append(sep);
		sb.append("serialNo").append(" = ").append(this.getSerialNo()).append(sep);
		sb.append("indexNo").append(" = ").append(this.getIndexNo()).append(sep);
		sb.append("visitDate").append(" = ").append(this.getVisitDate()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}