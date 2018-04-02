package com.chuangbu.weixin.register.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 说 明 :
 * 
 * @author 作 者：xjc 邮 箱：361cjx@163.com
 * @version 版 本：V1.0 时 间：2017年5月30日 下午2:43:02
 */
@XStreamAlias("Body")
public class OrderResultInfo implements Body {

	private String MedicareNo;
	private String ChargeNo;
	private String RegisterFee;
	private String DiagnosticFee;
	private String SumFee;
	private String PrivatePay;
	private String MedicareAccountPay;
	private String PoolingAccountPay;
	private String DeliveryMessage;

	public String getMedicareNo() {
		return MedicareNo;
	}

	public void setMedicareNo(String medicareNo) {
		MedicareNo = medicareNo;
	}

	public String getChargeNo() {
		return ChargeNo;
	}

	public void setChargeNo(String chargeNo) {
		ChargeNo = chargeNo;
	}

	public String getRegisterFee() {
		return RegisterFee;
	}

	public void setRegisterFee(String registerFee) {
		RegisterFee = registerFee;
	}

	public String getDiagnosticFee() {
		return DiagnosticFee;
	}

	public void setDiagnosticFee(String diagnosticFee) {
		DiagnosticFee = diagnosticFee;
	}

	public String getSumFee() {
		return SumFee;
	}

	public void setSumFee(String sumFee) {
		SumFee = sumFee;
	}

	public String getPrivatePay() {
		return PrivatePay;
	}

	public void setPrivatePay(String privatePay) {
		PrivatePay = privatePay;
	}

	public String getMedicareAccountPay() {
		return MedicareAccountPay;
	}

	public void setMedicareAccountPay(String medicareAccountPay) {
		MedicareAccountPay = medicareAccountPay;
	}

	public String getPoolingAccountPay() {
		return PoolingAccountPay;
	}

	public void setPoolingAccountPay(String poolingAccountPay) {
		PoolingAccountPay = poolingAccountPay;
	}

	public String getDeliveryMessage() {
		return DeliveryMessage;
	}

	public void setDeliveryMessage(String deliveryMessage) {
		DeliveryMessage = deliveryMessage;
	}

}
