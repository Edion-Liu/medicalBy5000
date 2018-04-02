package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.DocterPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_docter Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-04 23:40:59
 */
public class Docter extends DocterPo implements Domain {

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
			
		if(this.getName().getBytes().length > 150)
			sb.append("姓名宽度不能超过150个字符！");
			
		if(this.getTitle().getBytes().length > 150)
			sb.append("职称宽度不能超过150个字符！");
			
		if(this.getPosition().getBytes().length > 90)
			sb.append("职务宽度不能超过90个字符！");
			
		if(this.getSex().getBytes().length > 3)
			sb.append("性别宽度不能超过3个字符！");
			
		if(this.getPhotoPath().getBytes().length > 150)
			sb.append("相片路径宽度不能超过150个字符！");
			
		if(this.getTel().getBytes().length > 45)
			sb.append("联系电话宽度不能超过45个字符！");
			
		if(this.getRemark().getBytes().length > 600)
			sb.append("备注宽度不能超过600个字符！");
			
		if(this.getOrgId().getBytes().length > 96)
			sb.append("所属部门宽度不能超过96个字符！");
			
		if(this.getUnit().getBytes().length > 60)
			sb.append("所属组织宽度不能超过60个字符！");
			
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
			map.put("title",this.getTitle());
			map.put("position",this.getPosition());
			map.put("age",this.getAge());
			map.put("sex",this.getSex());
			map.put("photopath",this.getPhotoPath());
			map.put("tel",this.getTel());
			map.put("level",this.getLevel());
			map.put("remark",this.getRemark());
			map.put("orgid",this.getOrgId());
			map.put("unit",this.getUnit());
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
		if(map.containsKey("title")){
			if(null==map.get("title")){
				this.setTitle(null);
			}else{
				this.setTitle((String)map.get("title"));
			}
		}
		if(map.containsKey("position")){
			if(null==map.get("position")){
				this.setPosition(null);
			}else{
				this.setPosition((String)map.get("position"));
			}
		}
		if(map.containsKey("age")){
			if(null==map.get("age")){
				this.setAge(null);
			}else{
				this.setAge((Integer)map.get("age"));
			}
		}
		if(map.containsKey("sex")){
			if(null==map.get("sex")){
				this.setSex(null);
			}else{
				this.setSex((String)map.get("sex"));
			}
		}
		if(map.containsKey("photopath")){
			if(null==map.get("photopath")){
				this.setPhotoPath(null);
			}else{
				this.setPhotoPath((String)map.get("photopath"));
			}
		}
		if(map.containsKey("tel")){
			if(null==map.get("tel")){
				this.setTel(null);
			}else{
				this.setTel((String)map.get("tel"));
			}
		}
		if(map.containsKey("level")){
			if(null==map.get("level")){
				this.setLevel(null);
			}else{
				this.setLevel((Integer)map.get("level"));
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
		if(map.containsKey("unit")){
			if(null==map.get("unit")){
				this.setUnit(null);
			}else{
				this.setUnit((String)map.get("unit"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("DocterPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("title").append(" = ").append(this.getTitle()).append(sep);
		sb.append("position").append(" = ").append(this.getPosition()).append(sep);
		sb.append("age").append(" = ").append(this.getAge()).append(sep);
		sb.append("sex").append(" = ").append(this.getSex()).append(sep);
		sb.append("photoPath").append(" = ").append(this.getPhotoPath()).append(sep);
		sb.append("tel").append(" = ").append(this.getTel()).append(sep);
		sb.append("level").append(" = ").append(this.getLevel()).append(sep);
		sb.append("remark").append(" = ").append(this.getRemark()).append(sep);
		sb.append("orgId").append(" = ").append(this.getOrgId()).append(sep);
		sb.append("unit").append(" = ").append(this.getUnit()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}