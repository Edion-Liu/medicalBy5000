package com.chuangbu.core.orm.hospital.po;

import java.sql.Timestamp;

import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_register_order Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-06-11 23:28:42
 */
public class RegisterOrderPo extends AbstractPo{
	// id
	private	String	id;
	// 订单
	private	String	orderNo;
	// 预支付交易会话标识
	private	String	prepayId;
	// 公众账号ID
	private	String	appid;
	// 商户号
	private	String	mchId;
	// 商品描述
	private	String	body;
	// 商户订单号
	private	String	outTradeNo;
	// total_fee
	private	Integer	totalFee;
	// 终端IP
	private	String	spbillCreateIp;
	// 用户标识
	private	String	openid;
	// 状态
	private	String	status;
	// 就诊卡号
	private	String	cardId;
	// 患者姓名
	private	String	customerName;
	// 身份证号
	private	String	certificateNo;
	// 病人电话
	private	String	phoneCode;
	// 科室编码
	private	String	deptCode;
	// 就诊科室名称
	private	String	deptName;
	// 医生编码
	private	String	docterCode;
	// 就诊医生名称
	private	String	doctorName;
	// 就诊科室位置
	private	String	deptPosition;
	// ct
	private	Timestamp	ct;
	// 微信支付订单号
	private	String	transactionId;
	// 门诊号
	private	String	outpatientNo;
	// 流水号
	private	String	serialNo;
	// 就诊序号
	private	String	indexNo;
	// 就诊日期
	private	String	visitDate;

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * id
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 订单
	 * @return
	 */
	public String getOrderNo() {
		return orderNo;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	/**
	 * 预支付交易会话标识
	 * @return
	 */
	public String getPrepayId() {
		return prepayId;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 公众账号ID
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 商户号
	 * @return
	 */
	public String getMchId() {
		return mchId;
	}

	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 商品描述
	 * @return
	 */
	public String getBody() {
		return body;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 商户订单号
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * total_fee
	 * @return
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	/**
	 * 终端IP
	 * @return
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 用户标识
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/**
	 * 就诊卡号
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 患者姓名
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	/**
	 * 身份证号
	 * @return
	 */
	public String getCertificateNo() {
		return certificateNo;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	/**
	 * 病人电话
	 * @return
	 */
	public String getPhoneCode() {
		return phoneCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * 科室编码
	 * @return
	 */
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 就诊科室名称
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	public void setDocterCode(String docterCode) {
		this.docterCode = docterCode;
	}
	/**
	 * 医生编码
	 * @return
	 */
	public String getDocterCode() {
		return docterCode;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * 就诊医生名称
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}

	public void setDeptPosition(String deptPosition) {
		this.deptPosition = deptPosition;
	}
	/**
	 * 就诊科室位置
	 * @return
	 */
	public String getDeptPosition() {
		return deptPosition;
	}

	public void setCt(Timestamp ct) {
		this.ct = ct;
	}
	/**
	 * ct
	 * @return
	 */
	public Timestamp getCt() {
		return ct;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * 微信支付订单号
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}
	/**
	 * 门诊号
	 * @return
	 */
	public String getOutpatientNo() {
		return outpatientNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 流水号
	 * @return
	 */
	public String getSerialNo() {
		return serialNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}
	/**
	 * 就诊序号
	 * @return
	 */
	public String getIndexNo() {
		return indexNo;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	/**
	 * 就诊日期
	 * @return
	 */
	public String getVisitDate() {
		return visitDate;
	}
}