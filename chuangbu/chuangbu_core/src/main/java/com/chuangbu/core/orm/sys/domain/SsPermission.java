package com.chuangbu.core.orm.sys.domain;

import java.util.HashMap;
import java.util.Map;

import com.chuangbu.common.core.orm.domain.Domain;
import com.chuangbu.core.orm.sys.po.SsPermissionPo;
/**
 * Description: ss_permission Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-26 10:17:52
 */
public class SsPermission extends SsPermissionPo implements Domain {

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
			
		if(this.getDisplayName() == null)
			sb.append("display_name不能为空！");
			
		if(this.getName() == null)
			sb.append("name不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getExpanded().getBytes().length > 600)
			sb.append("expanded_宽度不能超过600个字符！");
			
		if(this.getLoaded().getBytes().length > 150)
			sb.append("loaded_宽度不能超过150个字符！");
			
		if(this.getDisplayName().getBytes().length > 1500)
			sb.append("display_name宽度不能超过1,500个字符！");
			
		if(this.getIconname().getBytes().length > 300)
			sb.append("iconname宽度不能超过300个字符！");
			
		if(this.getName().getBytes().length > 150)
			sb.append("name宽度不能超过150个字符！");
			
		if(this.getUrl().getBytes().length > 300)
			sb.append("url宽度不能超过300个字符！");
			
		if(this.getParent().getBytes().length > 96)
			sb.append("parent_宽度不能超过96个字符！");
			
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
			map.put("expanded",this.getExpanded());
			map.put("leaf",this.getLeaf());
			map.put("level",this.getLevel());
			map.put("loaded",this.getLoaded());
			map.put("order",this.getOrder());
			map.put("displayname",this.getDisplayName());
			map.put("iconname",this.getIconname());
			map.put("menu",this.getMenu());
			map.put("name",this.getName());
			map.put("url",this.getUrl());
			map.put("parent",this.getParent());
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
		if(map.containsKey("expanded")){
			if(null==map.get("expanded")){
				this.setExpanded(null);
			}else{
				this.setExpanded((String)map.get("expanded"));
			}
		}
		if(map.containsKey("leaf")){
			if(null==map.get("leaf")){
				this.setLeaf(null);
			}else{
				this.setLeaf((Short)map.get("leaf"));
			}
		}
		if(map.containsKey("level")){
			if(null==map.get("level")){
				this.setLevel(null);
			}else{
				this.setLevel((Integer)map.get("level"));
			}
		}
		if(map.containsKey("loaded")){
			if(null==map.get("loaded")){
				this.setLoaded(null);
			}else{
				this.setLoaded((String)map.get("loaded"));
			}
		}
		if(map.containsKey("order")){
			if(null==map.get("order")){
				this.setOrder(null);
			}else{
				this.setOrder((Double)map.get("order"));
			}
		}
		if(map.containsKey("displayname")){
			if(null==map.get("displayname")){
				this.setDisplayName(null);
			}else{
				this.setDisplayName((String)map.get("displayname"));
			}
		}
		if(map.containsKey("iconname")){
			if(null==map.get("iconname")){
				this.setIconname(null);
			}else{
				this.setIconname((String)map.get("iconname"));
			}
		}
		if(map.containsKey("menu")){
			if(null==map.get("menu")){
				this.setMenu(null);
			}else{
				this.setMenu((Short)map.get("menu"));
			}
		}
		if(map.containsKey("name")){
			if(null==map.get("name")){
				this.setName(null);
			}else{
				this.setName((String)map.get("name"));
			}
		}
		if(map.containsKey("url")){
			if(null==map.get("url")){
				this.setUrl(null);
			}else{
				this.setUrl((String)map.get("url"));
			}
		}
		if(map.containsKey("parent")){
			if(null==map.get("parent")){
				this.setParent(null);
			}else{
				this.setParent((String)map.get("parent"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("SsPermissionPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("expanded").append(" = ").append(this.getExpanded()).append(sep);
		sb.append("leaf").append(" = ").append(this.getLeaf()).append(sep);
		sb.append("level").append(" = ").append(this.getLevel()).append(sep);
		sb.append("loaded").append(" = ").append(this.getLoaded()).append(sep);
		sb.append("order").append(" = ").append(this.getOrder()).append(sep);
		sb.append("displayName").append(" = ").append(this.getDisplayName()).append(sep);
		sb.append("iconname").append(" = ").append(this.getIconname()).append(sep);
		sb.append("menu").append(" = ").append(this.getMenu()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("url").append(" = ").append(this.getUrl()).append(sep);
		sb.append("parent").append(" = ").append(this.getParent()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}