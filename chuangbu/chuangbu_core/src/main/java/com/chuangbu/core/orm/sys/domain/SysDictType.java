package com.chuangbu.core.orm.sys.domain;

import java.util.HashMap;
import java.util.Map;

import com.chuangbu.common.core.orm.domain.Domain;
import com.chuangbu.core.orm.sys.po.SysDictTypePo;
/**
 * Description: sys_dict_type Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-25 21:42:37
 */
public class SysDictType extends SysDictTypePo implements Domain {

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
			
		if(this.getTypename() == null)
			sb.append("typename不能为空！");
			
		if(this.getTypesign() == null)
			sb.append("typesign不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getTypename().getBytes().length > 765)
			sb.append("typename宽度不能超过765个字符！");
			
		if(this.getTypesign().getBytes().length > 765)
			sb.append("typesign宽度不能超过765个字符！");
			
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
			map.put("typename",this.getTypename());
			map.put("typesign",this.getTypesign());
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
		if(map.containsKey("typename")){
			if(null==map.get("typename")){
				this.setTypename(null);
			}else{
				this.setTypename((String)map.get("typename"));
			}
		}
		if(map.containsKey("typesign")){
			if(null==map.get("typesign")){
				this.setTypesign(null);
			}else{
				this.setTypesign((String)map.get("typesign"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("SysDictTypePo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("typename").append(" = ").append(this.getTypename()).append(sep);
		sb.append("typesign").append(" = ").append(this.getTypesign()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}