package com.chuangbu.core.orm.sys.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.sys.po.SsRolePo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: ss_role Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 14:28:23
 */
public class SsRole extends SsRolePo implements Domain {

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
			
		if(this.getName() == null)
			sb.append("name不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getName().getBytes().length > 150)
			sb.append("name宽度不能超过150个字符！");
			
		if(this.getNote().getBytes().length > 150)
			sb.append("note宽度不能超过150个字符！");
			
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
			map.put("name",this.getName());
			map.put("note",this.getNote());
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
		if(map.containsKey("name")){
			if(null==map.get("name")){
				this.setName(null);
			}else{
				this.setName((String)map.get("name"));
			}
		}
		if(map.containsKey("note")){
			if(null==map.get("note")){
				this.setNote(null);
			}else{
				this.setNote((String)map.get("note"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("SsRolePo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("note").append(" = ").append(this.getNote()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}