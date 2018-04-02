package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.TOrgMenuPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_org_menu Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 13:11:42
 */
public class TOrgMenu extends TOrgMenuPo implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderBy;	
	
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public void onSave(){
		//this.id=System.currentTimeMillis();
	}
	
	public String validate(){
		StringBuffer sb = new StringBuffer();
			
		if(this.getId() == null)
			sb.append("id不能为空！");
		
		if(this.getId().getBytes().length > 96)
			sb.append("id宽度不能超过96个字符！");
			
		if(this.getMenuName().getBytes().length > 200)
			sb.append("菜单名称宽度不能超过200个字符！");
			
		if(this.getMenuCode().getBytes().length > 45)
			sb.append("菜单编码宽度不能超过45个字符！");
			
		if(this.getMenuUrl().getBytes().length > 150)
			sb.append("菜单路径宽度不能超过150个字符！");
			
		if(this.getIcoPath().getBytes().length > 150)
			sb.append("图标路径宽度不能超过150个字符！");
			
		if(this.getParent().getBytes().length > 96)
			sb.append("父级菜单宽度不能超过96个字符！");
			
		if(this.getOrgId().getBytes().length > 96)
			sb.append("组织ID宽度不能超过96个字符！");
			
		if(this.getMenuType().getBytes().length > 6)
			sb.append("菜单类型宽度不能超过6个字符！");
			
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
			map.put("menuname",this.getMenuName());
			map.put("menucode",this.getMenuCode());
			map.put("menuurl",this.getMenuUrl());
			map.put("icopath",this.getIcoPath());
			map.put("level",this.getLevel());
			map.put("disorder",this.getDisOrder());
			map.put("parent",this.getParent());
			map.put("children",this.getChildren());
			map.put("valid",this.getValid());
			map.put("orgid",this.getOrgId());
			map.put("menutype",this.getMenuType());
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
		if(map.containsKey("menuname")){
			if(null==map.get("menuname")){
				this.setMenuName(null);
			}else{
				this.setMenuName((String)map.get("menuname"));
			}
		}
		if(map.containsKey("menucode")){
			if(null==map.get("menucode")){
				this.setMenuCode(null);
			}else{
				this.setMenuCode((String)map.get("menucode"));
			}
		}
		if(map.containsKey("menuurl")){
			if(null==map.get("menuurl")){
				this.setMenuUrl(null);
			}else{
				this.setMenuUrl((String)map.get("menuurl"));
			}
		}
		if(map.containsKey("icopath")){
			if(null==map.get("icopath")){
				this.setIcoPath(null);
			}else{
				this.setIcoPath((String)map.get("icopath"));
			}
		}
		if(map.containsKey("level")){
			if(null==map.get("level")){
				this.setLevel(null);
			}else{
				this.setLevel((Integer)map.get("level"));
			}
		}
		if(map.containsKey("disorder")){
			if(null==map.get("disorder")){
				this.setDisOrder(null);
			}else{
				this.setDisOrder((Integer)map.get("disorder"));
			}
		}
		if(map.containsKey("parent")){
			if(null==map.get("parent")){
				this.setParent(null);
			}else{
				this.setParent((String)map.get("parent"));
			}
		}
		if(map.containsKey("children")){
			if(null==map.get("children")){
				this.setChildren(null);
			}else{
				this.setChildren((Short)map.get("children"));
			}
		}
		if(map.containsKey("valid")){
			if(null==map.get("valid")){
				this.setValid(null);
			}else{
				this.setValid((Short)map.get("valid"));
			}
		}
		if(map.containsKey("orgid")){
			if(null==map.get("orgid")){
				this.setOrgId(null);
			}else{
				this.setOrgId((String)map.get("orgid"));
			}
		}
		if(map.containsKey("menutype")){
			if(null==map.get("menutype")){
				this.setMenuType(null);
			}else{
				this.setMenuType((String)map.get("menutype"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("TOrgMenuPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("menuName").append(" = ").append(this.getMenuName()).append(sep);
		sb.append("menuCode").append(" = ").append(this.getMenuCode()).append(sep);
		sb.append("menuUrl").append(" = ").append(this.getMenuUrl()).append(sep);
		sb.append("icoPath").append(" = ").append(this.getIcoPath()).append(sep);
		sb.append("level").append(" = ").append(this.getLevel()).append(sep);
		sb.append("disOrder").append(" = ").append(this.getDisOrder()).append(sep);
		sb.append("parent").append(" = ").append(this.getParent()).append(sep);
		sb.append("children").append(" = ").append(this.getChildren()).append(sep);
		sb.append("valid").append(" = ").append(this.getValid()).append(sep);
		sb.append("orgId").append(" = ").append(this.getOrgId()).append(sep);
		sb.append("menuType").append(" = ").append(this.getMenuType()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}