package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.TAppConfigPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_app_config Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-06 18:33:15
 */
public class TAppConfig extends TAppConfigPo implements Domain {

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
			
		if(this.getAppId().getBytes().length > 150)
			sb.append("应用id宽度不能超过150个字符！");
			
		if(this.getMehId().getBytes().length > 60)
			sb.append("商户id宽度不能超过60个字符！");
			
		if(this.getAppsecret().getBytes().length > 150)
			sb.append("应用验证宽度不能超过150个字符！");
			
		if(this.getAppKey().getBytes().length > 150)
			sb.append("应用key宽度不能超过150个字符！");
			
		if(this.getRemark().getBytes().length > 300)
			sb.append("备注宽度不能超过300个字符！");
			
		if(this.getOrgId().getBytes().length > 96)
			sb.append("组织id宽度不能超过96个字符！");
			
		if(this.getRpcUrl().getBytes().length > 300)
			sb.append("rpc服务地址宽度不能超过300个字符！");
			
		if(this.getName().getBytes().length > 150)
			sb.append("名称宽度不能超过150个字符！");
			
		if(this.getCode().getBytes().length > 90)
			sb.append("编码宽度不能超过90个字符！");
			
		if(this.getAddress().getBytes().length > 300)
			sb.append("地址宽度不能超过300个字符！");
			
		if(this.getLongitude().getBytes().length > 90)
			sb.append("经度宽度不能超过90个字符！");
			
		if(this.getLatitude().getBytes().length > 90)
			sb.append("纬度宽度不能超过90个字符！");
			
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
			map.put("appid",this.getAppId());
			map.put("mehid",this.getMehId());
			map.put("appsecret",this.getAppsecret());
			map.put("appkey",this.getAppKey());
			map.put("remark",this.getRemark());
			map.put("orgid",this.getOrgId());
			map.put("rpcurl",this.getRpcUrl());
			map.put("name",this.getName());
			map.put("code",this.getCode());
			map.put("address",this.getAddress());
			map.put("longitude",this.getLongitude());
			map.put("latitude",this.getLatitude());
			map.put("valid",this.getValid());
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
		if(map.containsKey("appid")){
			if(null==map.get("appid")){
				this.setAppId(null);
			}else{
				this.setAppId((String)map.get("appid"));
			}
		}
		if(map.containsKey("mehid")){
			if(null==map.get("mehid")){
				this.setMehId(null);
			}else{
				this.setMehId((String)map.get("mehid"));
			}
		}
		if(map.containsKey("appsecret")){
			if(null==map.get("appsecret")){
				this.setAppsecret(null);
			}else{
				this.setAppsecret((String)map.get("appsecret"));
			}
		}
		if(map.containsKey("appkey")){
			if(null==map.get("appkey")){
				this.setAppKey(null);
			}else{
				this.setAppKey((String)map.get("appkey"));
			}
		}
		if(map.containsKey("remark")){
			if(null==map.get("remark")){
				this.setRemark(null);
			}else{
				this.setRemark((String)map.get("remark"));
			}
		}
		if(map.containsKey("orgid")){
			if(null==map.get("orgid")){
				this.setOrgId(null);
			}else{
				this.setOrgId((String)map.get("orgid"));
			}
		}
		if(map.containsKey("rpcurl")){
			if(null==map.get("rpcurl")){
				this.setRpcUrl(null);
			}else{
				this.setRpcUrl((String)map.get("rpcurl"));
			}
		}
		if(map.containsKey("name")){
			if(null==map.get("name")){
				this.setName(null);
			}else{
				this.setName((String)map.get("name"));
			}
		}
		if(map.containsKey("code")){
			if(null==map.get("code")){
				this.setCode(null);
			}else{
				this.setCode((String)map.get("code"));
			}
		}
		if(map.containsKey("address")){
			if(null==map.get("address")){
				this.setAddress(null);
			}else{
				this.setAddress((String)map.get("address"));
			}
		}
		if(map.containsKey("longitude")){
			if(null==map.get("longitude")){
				this.setLongitude(null);
			}else{
				this.setLongitude((String)map.get("longitude"));
			}
		}
		if(map.containsKey("latitude")){
			if(null==map.get("latitude")){
				this.setLatitude(null);
			}else{
				this.setLatitude((String)map.get("latitude"));
			}
		}
		if(map.containsKey("valid")){
			if(null==map.get("valid")){
				this.setValid(null);
			}else{
				this.setValid((Short)map.get("valid"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("TAppConfigPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("appId").append(" = ").append(this.getAppId()).append(sep);
		sb.append("mehId").append(" = ").append(this.getMehId()).append(sep);
		sb.append("appsecret").append(" = ").append(this.getAppsecret()).append(sep);
		sb.append("appKey").append(" = ").append(this.getAppKey()).append(sep);
		sb.append("remark").append(" = ").append(this.getRemark()).append(sep);
		sb.append("orgId").append(" = ").append(this.getOrgId()).append(sep);
		sb.append("rpcUrl").append(" = ").append(this.getRpcUrl()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("code").append(" = ").append(this.getCode()).append(sep);
		sb.append("address").append(" = ").append(this.getAddress()).append(sep);
		sb.append("longitude").append(" = ").append(this.getLongitude()).append(sep);
		sb.append("latitude").append(" = ").append(this.getLatitude()).append(sep);
		sb.append("valid").append(" = ").append(this.getValid()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}