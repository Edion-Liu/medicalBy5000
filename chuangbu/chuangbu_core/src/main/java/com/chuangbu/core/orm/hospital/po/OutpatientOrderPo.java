package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_outpatient_order Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-08-27 23:27:55
 */
public class OutpatientOrderPo extends AbstractPo{
	// id
	private	String	id;
	// 微信id
	private	String	prepayId;
	// 公众号id
	private	String	appid;
	// 商户id
	private	String	mchId;
	// 支付内容
	private	String	body;
	// 外部订单编号
	private	String	outTradeNo;
	// 金额
	private	Integer	totalFee;
	// ip
	private	String	spbillCreateIp;
	// 用户id
	private	String	openid;
	// 状态
	private	String	status;
	// 身份证号
	private	String	certificateNo;
	// 门诊号
	private	String	outpatientNo;
	// 交易订单
	private	String	transactionId;
	// 处方号
	private	String	prescNo;
	// 创建时间
	private	Timestamp	ct;
	// 患者姓名
	private	String	customerName;
	// 流水号
	private	String	serialNo;
	// 医生
	private	String	doctorName;
	// 科室名称
	private	String	deptName;

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

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	/**
	 * 微信id
	 * @return
	 */
	public String getPrepayId() {
		return prepayId;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 公众号id
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 商户id
	 * @return
	 */
	public String getMchId() {
		return mchId;
	}

	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 支付内容
	 * @return
	 */
	public String getBody() {
		return body;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 外部订单编号
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 金额
	 * @return
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	/**
	 * ip
	 * @return
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 用户id
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

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * 交易订单
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	public void setPrescNo(String prescNo) {
		this.prescNo = prescNo;
	}
	/**
	 * 处方号
	 * @return
	 */
	public String getPrescNo() {
		return prescNo;
	}

	public void setCt(Timestamp ct) {
		this.ct = ct;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public Timestamp getCt() {
		return ct;
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

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * 医生
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 科室名称
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}
}