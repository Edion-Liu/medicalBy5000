package com.chuangbu.core.orm.sys.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.sys.po.SsUserPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: ss_user Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 15:10:49
 */
public class SsUser extends SsUserPo implements Domain {

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
			
		if(this.getLoginName() == null)
			sb.append("login_name不能为空！");
			
		if(this.getName() == null)
			sb.append("name不能为空！");
			
		if(this.getPassword() == null)
			sb.append("password不能为空！");
			
		if(this.getSalt() == null)
			sb.append("salt不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getLoginName().getBytes().length > 300)
			sb.append("login_name宽度不能超过300个字符！");
			
		if(this.getName().getBytes().length > 150)
			sb.append("name宽度不能超过150个字符！");
			
		if(this.getPassword().getBytes().length > 150)
			sb.append("password宽度不能超过150个字符！");
			
		if(this.getSalt().getBytes().length > 300)
			sb.append("salt宽度不能超过300个字符！");
			
		if(this.getEmail().getBytes().length > 300)
			sb.append("email宽度不能超过300个字符！");
			
		if(this.getStatus().getBytes().length > 30)
			sb.append("status宽度不能超过30个字符！");
			
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
			map.put("loginname",this.getLoginName());
			map.put("name",this.getName());
			map.put("password",this.getPassword());
			map.put("salt",this.getSalt());
			map.put("createtime",this.getCreatetime());
			map.put("email",this.getEmail());
			map.put("status",this.getStatus());
			map.put("locked",this.getLocked());
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
		if(map.containsKey("loginname")){
			if(null==map.get("loginname")){
				this.setLoginName(null);
			}else{
				this.setLoginName((String)map.get("loginname"));
			}
		}
		if(map.containsKey("name")){
			if(null==map.get("name")){
				this.setName(null);
			}else{
				this.setName((String)map.get("name"));
			}
		}
		if(map.containsKey("password")){
			if(null==map.get("password")){
				this.setPassword(null);
			}else{
				this.setPassword((String)map.get("password"));
			}
		}
		if(map.containsKey("salt")){
			if(null==map.get("salt")){
				this.setSalt(null);
			}else{
				this.setSalt((String)map.get("salt"));
			}
		}
		if(map.containsKey("createtime")){
			if(null==map.get("createtime")){
				this.setCreatetime(null);
			}else{
				this.setCreatetime((Date)map.get("createtime"));
			}
		}
		if(map.containsKey("email")){
			if(null==map.get("email")){
				this.setEmail(null);
			}else{
				this.setEmail((String)map.get("email"));
			}
		}
		if(map.containsKey("status")){
			if(null==map.get("status")){
				this.setStatus(null);
			}else{
				this.setStatus((String)map.get("status"));
			}
		}
		if(map.containsKey("locked")){
			if(null==map.get("locked")){
				this.setLocked(null);
			}else{
				this.setLocked((Long)map.get("locked"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("SsUserPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("loginName").append(" = ").append(this.getLoginName()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("password").append(" = ").append(this.getPassword()).append(sep);
		sb.append("salt").append(" = ").append(this.getSalt()).append(sep);
		sb.append("createtime").append(" = ").append(this.getCreatetime()).append(sep);
		sb.append("email").append(" = ").append(this.getEmail()).append(sep);
		sb.append("status").append(" = ").append(this.getStatus()).append(sep);
		sb.append("locked").append(" = ").append(this.getLocked()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}