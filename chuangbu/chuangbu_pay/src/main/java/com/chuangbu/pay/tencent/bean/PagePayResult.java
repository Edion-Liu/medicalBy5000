package com.chuangbu.pay.tencent.bean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 说 明 : 请求页面支付API需要提交的数据
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月2日 下午8:48:15
 */
@XStreamAlias("xml") 
public class PagePayResult {

	//返回状态码
	private String return_code ;
	//返回信息
	private String return_msg ;
	
	//以下字段在return_code为SUCCESS的时候有返回
    private String appid ;
    private String mch_id ;
    private String device_info ;
    private String nonce_str ;
    private String sign ;
    private String result_code ;
    private String err_code ;
    private String err_code_des ;
    //以下字段在return_code 和result_code都为SUCCESS的时候有返回
    private String trade_type ;
    private String prepay_id ;
    private String code_url ;
    
    public PagePayResult(){
    	
    }
    
    public PagePayResult(String returnCode,String returnMsg){
    	this.setReturn_code(returnCode);
    	this.setReturn_msg(returnMsg);
    }
    
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = String.format("<![CDATA[%s]]>", return_code);
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg =  String.format("<![CDATA[%s]]>", return_msg);
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = String.format("<![CDATA[%s]]>", result_code);
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
    
   public String getXML(){
	   PagePayResult res = new PagePayResult("SUCCESS", "OK");
		XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		xstream.autodetectAnnotations(true);
		String resultxml = xstream.toXML(res);
		return resultxml.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
   }
}
