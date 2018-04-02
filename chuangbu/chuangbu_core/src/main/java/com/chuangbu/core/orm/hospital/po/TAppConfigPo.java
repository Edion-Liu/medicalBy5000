package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_app_config Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-06 18:33:15
 */
public class TAppConfigPo extends AbstractPo{
	// id
	private	String	id;
	// 应用id
	private	String	appId;
	// 商户id
	private	String	mehId;
	// 应用验证
	private	String	appsecret;
	// 应用key
	private	String	appKey;
	// 备注
	private	String	remark;
	// 组织id
	private	String	orgId;
	// rpc服务地址
	private	String	rpcUrl;
	// 名称
	private	String	name;
	// 编码
	private	String	code;
	// 地址
	private	String	address;
	// 经度
	private	String	longitude;
	// 纬度
	private	String	latitude;
	// 是否有效
	private	Short	valid;

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

	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 应用id
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	public void setMehId(String mehId) {
		this.mehId = mehId;
	}
	/**
	 * 商户id
	 * @return
	 */
	public String getMehId() {
		return mehId;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	/**
	 * 应用验证
	 * @return
	 */
	public String getAppsecret() {
		return appsecret;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * 应用key
	 * @return
	 */
	public String getAppKey() {
		return appKey;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 组织id
	 * @return
	 */
	public String getOrgId() {
		return orgId;
	}

	public void setRpcUrl(String rpcUrl) {
		this.rpcUrl = rpcUrl;
	}
	/**
	 * rpc服务地址
	 * @return
	 */
	public String getRpcUrl() {
		return rpcUrl;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 编码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 经度
	 * @return
	 */
	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 纬度
	 * @return
	 */
	public String getLatitude() {
		return latitude;
	}

	public void setValid(Short valid) {
		this.valid = valid;
	}
	/**
	 * 是否有效
	 * @return
	 */
	public Short getValid() {
		return valid;
	}
}