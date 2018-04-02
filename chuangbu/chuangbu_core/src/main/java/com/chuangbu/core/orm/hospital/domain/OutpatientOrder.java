package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.OutpatientOrderPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_outpatient_order Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-08-27 23:27:55
 */
public class OutpatientOrder extends OutpatientOrderPo implements Domain {

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
			
		if(this.getPrepayId().getBytes().length > 576)
			sb.append("微信id宽度不能超过576个字符！");
			
		if(this.getAppid().getBytes().length > 96)
			sb.append("公众号id宽度不能超过96个字符！");
			
		if(this.getMchId().getBytes().length > 96)
			sb.append("商户id宽度不能超过96个字符！");
			
		if(this.getBody().getBytes().length > 900)
			sb.append("支付内容宽度不能超过900个字符！");
			
		if(this.getOutTradeNo().getBytes().length > 300)
			sb.append("外部订单编号宽度不能超过300个字符！");
			
		if(this.getSpbillCreateIp().getBytes().length > 144)
			sb.append("ip宽度不能超过144个字符！");
			
		if(this.getOpenid().getBytes().length > 384)
			sb.append("用户id宽度不能超过384个字符！");
			
		if(this.getStatus().getBytes().length > 18)
			sb.append("状态宽度不能超过18个字符！");
			
		if(this.getCertificateNo().getBytes().length > 60)
			sb.append("身份证号宽度不能超过60个字符！");
			
		if(this.getOutpatientNo().getBytes().length > 96)
			sb.append("门诊号宽度不能超过96个字符！");
			
		if(this.getTransactionId().getBytes().length > 96)
			sb.append("交易订单宽度不能超过96个字符！");
			
		if(this.getPrescNo().getBytes().length > 384)
			sb.append("处方号宽度不能超过384个字符！");
			
		if(this.getCustomerName().getBytes().length > 150)
			sb.append("患者姓名宽度不能超过150个字符！");
			
		if(this.getSerialNo().getBytes().length > 90)
			sb.append("流水号宽度不能超过90个字符！");
			
		if(this.getDoctorName().getBytes().length > 150)
			sb.append("医生宽度不能超过150个字符！");
			
		if(this.getDeptName().getBytes().length > 150)
			sb.append("科室名称宽度不能超过150个字符！");
			
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
			map.put("prepayid",this.getPrepayId());
			map.put("appid",this.getAppid());
			map.put("mchid",this.getMchId());
			map.put("body",this.getBody());
			map.put("outtradeno",this.getOutTradeNo());
			map.put("totalfee",this.getTotalFee());
			map.put("spbillcreateip",this.getSpbillCreateIp());
			map.put("openid",this.getOpenid());
			map.put("status",this.getStatus());
			map.put("certificateno",this.getCertificateNo());
			map.put("outpatientno",this.getOutpatientNo());
			map.put("transactionid",this.getTransactionId());
			map.put("prescno",this.getPrescNo());
			map.put("ct",this.getCt());
			map.put("customername",this.getCustomerName());
			map.put("serialno",this.getSerialNo());
			map.put("doctorname",this.getDoctorName());
			map.put("deptname",this.getDeptName());
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
		if(map.containsKey("certificateno")){
			if(null==map.get("certificateno")){
				this.setCertificateNo(null);
			}else{
				this.setCertificateNo((String)map.get("certificateno"));
			}
		}
		if(map.containsKey("outpatientno")){
			if(null==map.get("outpatientno")){
				this.setOutpatientNo(null);
			}else{
				this.setOutpatientNo((String)map.get("outpatientno"));
			}
		}
		if(map.containsKey("transactionid")){
			if(null==map.get("transactionid")){
				this.setTransactionId(null);
			}else{
				this.setTransactionId((String)map.get("transactionid"));
			}
		}
		if(map.containsKey("prescno")){
			if(null==map.get("prescno")){
				this.setPrescNo(null);
			}else{
				this.setPrescNo((String)map.get("prescno"));
			}
		}
		if(map.containsKey("ct")){
			if(null==map.get("ct")){
				this.setCt(null);
			}else{
				this.setCt((Timestamp)map.get("ct"));
			}
		}
		if(map.containsKey("customername")){
			if(null==map.get("customername")){
				this.setCustomerName(null);
			}else{
				this.setCustomerName((String)map.get("customername"));
			}
		}
		if(map.containsKey("serialno")){
			if(null==map.get("serialno")){
				this.setSerialNo(null);
			}else{
				this.setSerialNo((String)map.get("serialno"));
			}
		}
		if(map.containsKey("doctorname")){
			if(null==map.get("doctorname")){
				this.setDoctorName(null);
			}else{
				this.setDoctorName((String)map.get("doctorname"));
			}
		}
		if(map.containsKey("deptname")){
			if(null==map.get("deptname")){
				this.setDeptName(null);
			}else{
				this.setDeptName((String)map.get("deptname"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("OutpatientOrderPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("prepayId").append(" = ").append(this.getPrepayId()).append(sep);
		sb.append("appid").append(" = ").append(this.getAppid()).append(sep);
		sb.append("mchId").append(" = ").append(this.getMchId()).append(sep);
		sb.append("body").append(" = ").append(this.getBody()).append(sep);
		sb.append("outTradeNo").append(" = ").append(this.getOutTradeNo()).append(sep);
		sb.append("totalFee").append(" = ").append(this.getTotalFee()).append(sep);
		sb.append("spbillCreateIp").append(" = ").append(this.getSpbillCreateIp()).append(sep);
		sb.append("openid").append(" = ").append(this.getOpenid()).append(sep);
		sb.append("status").append(" = ").append(this.getStatus()).append(sep);
		sb.append("certificateNo").append(" = ").append(this.getCertificateNo()).append(sep);
		sb.append("outpatientNo").append(" = ").append(this.getOutpatientNo()).append(sep);
		sb.append("transactionId").append(" = ").append(this.getTransactionId()).append(sep);
		sb.append("prescNo").append(" = ").append(this.getPrescNo()).append(sep);
		sb.append("ct").append(" = ").append(this.getCt()).append(sep);
		sb.append("customerName").append(" = ").append(this.getCustomerName()).append(sep);
		sb.append("serialNo").append(" = ").append(this.getSerialNo()).append(sep);
		sb.append("doctorName").append(" = ").append(this.getDoctorName()).append(sep);
		sb.append("deptName").append(" = ").append(this.getDeptName()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}