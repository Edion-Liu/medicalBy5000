package com.chuangbu.weixin.register.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月30日 下午2:43:16
 */
@XStreamAlias("Request") 
public class Request {

	private String DealType;
	private String DealCode;
	private String CardID;
	private String CustomerName;
	private String Sex;
	private String Birthday;
	private String CertificateNo;
	private String PhoneCode;
	private String PhoneCodeContact;
	private Body Body;
	
	public String getDealType() {
		return DealType;
	}
	public void setDealType(String dealType) {
		DealType = dealType;
	}
	public String getDealCode() {
		return DealCode;
	}
	public void setDealCode(String dealCode) {
		DealCode = dealCode;
	}
	public String getCardID() {
		return CardID;
	}
	public void setCardID(String cardID) {
		CardID = cardID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getCertificateNo() {
		return CertificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		CertificateNo = certificateNo;
	}
	public String getPhoneCode() {
		return PhoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		PhoneCode = phoneCode;
	}
	public String getPhoneCodeContact() {
		return PhoneCodeContact;
	}
	public void setPhoneCodeContact(String phoneCodeContact) {
		PhoneCodeContact = phoneCodeContact;
	}
	public Body getBody() {
		return Body;
	}
	public void setBody(Body body) {
		Body = body;
	}
	
}
