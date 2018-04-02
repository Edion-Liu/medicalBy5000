package com.chuangbu.weixin.register.bean;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月30日 下午2:43:02
 */

public class OrderPayInfo implements Body {

	private String MedicareNo;
	private String ChargeNo;
	private String NetchargeID;
	
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
	public String getNetchargeID() {
		return NetchargeID;
	}
	public void setNetchargeID(String netchargeID) {
		NetchargeID = netchargeID;
	}
	
}
