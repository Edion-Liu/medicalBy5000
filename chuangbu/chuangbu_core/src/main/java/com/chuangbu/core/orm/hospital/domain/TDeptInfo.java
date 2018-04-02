package com.chuangbu.core.orm.hospital.domain;

import java.util.HashMap;
import java.util.Map;

import com.chuangbu.common.core.orm.domain.Domain;
import com.chuangbu.core.orm.hospital.po.TDeptInfoPo;
/**
 * Description: t_dept_info Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:25
 */
public class TDeptInfo extends TDeptInfoPo implements Domain {

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
			
		if(this.getName().getBytes().length > 150)
			sb.append("科室名称宽度不能超过150个字符！");
			
		if(this.getCode().getBytes().length > 45)
			sb.append("科室编码宽度不能超过45个字符！");
			
		if(this.getDeptUrl().getBytes().length > 150)
			sb.append("科室url宽度不能超过150个字符！");
			
		if(this.getDeptUrlType().getBytes().length > 6)
			sb.append("科室url类型宽度不能超过6个字符！");
			
		if(this.getIcoPath().getBytes().length > 150)
			sb.append("图标路径宽度不能超过150个字符！");
			
		if(this.getOrgId().getBytes().length > 96)
			sb.append("组织id宽度不能超过96个字符！");
			
		if(this.getSynopsis().getBytes().length > 3000)
			sb.append("科室简介宽度不能超过3,000个字符！");
			
		if(this.getSpecialty().getBytes().length > 3000)
			sb.append("科室擅长宽度不能超过3,000个字符！");
			
		if(this.getTeam().getBytes().length > 3000)
			sb.append("团队组成宽度不能超过3,000个字符！");
			
		if(this.getEquipment().getBytes().length > 3000)
			sb.append("先进设备宽度不能超过3,000个字符！");
			
		if(this.getAchievements().getBytes().length > 3000)
			sb.append("科研成果宽度不能超过3,000个字符！");
			
		if(this.getRemark().getBytes().length > 150)
			sb.append("备注宽度不能超过150个字符！");
			
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
			map.put("code",this.getCode());
			map.put("level",this.getLevel());
			map.put("depturl",this.getDeptUrl());
			map.put("depturltype",this.getDeptUrlType());
			map.put("icopath",this.getIcoPath());
			map.put("valid",this.getValid());
			map.put("orgid",this.getOrgId());
			map.put("synopsis",this.getSynopsis());
			map.put("specialty",this.getSpecialty());
			map.put("team",this.getTeam());
			map.put("equipment",this.getEquipment());
			map.put("achievements",this.getAchievements());
			map.put("disorder",this.getDisOrder());
			map.put("remark",this.getRemark());
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
		if(map.containsKey("code")){
			if(null==map.get("code")){
				this.setCode(null);
			}else{
				this.setCode((String)map.get("code"));
			}
		}
		if(map.containsKey("level")){
			if(null==map.get("level")){
				this.setLevel(null);
			}else{
				this.setLevel((Integer)map.get("level"));
			}
		}
		if(map.containsKey("depturl")){
			if(null==map.get("depturl")){
				this.setDeptUrl(null);
			}else{
				this.setDeptUrl((String)map.get("depturl"));
			}
		}
		if(map.containsKey("depturltype")){
			if(null==map.get("depturltype")){
				this.setDeptUrlType(null);
			}else{
				this.setDeptUrlType((String)map.get("depturltype"));
			}
		}
		if(map.containsKey("icopath")){
			if(null==map.get("icopath")){
				this.setIcoPath(null);
			}else{
				this.setIcoPath((String)map.get("icopath"));
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
		if(map.containsKey("synopsis")){
			if(null==map.get("synopsis")){
				this.setSynopsis(null);
			}else{
				this.setSynopsis((String)map.get("synopsis"));
			}
		}
		if(map.containsKey("specialty")){
			if(null==map.get("specialty")){
				this.setSpecialty(null);
			}else{
				this.setSpecialty((String)map.get("specialty"));
			}
		}
		if(map.containsKey("team")){
			if(null==map.get("team")){
				this.setTeam(null);
			}else{
				this.setTeam((String)map.get("team"));
			}
		}
		if(map.containsKey("equipment")){
			if(null==map.get("equipment")){
				this.setEquipment(null);
			}else{
				this.setEquipment((String)map.get("equipment"));
			}
		}
		if(map.containsKey("achievements")){
			if(null==map.get("achievements")){
				this.setAchievements(null);
			}else{
				this.setAchievements((String)map.get("achievements"));
			}
		}
		if(map.containsKey("disorder")){
			if(null==map.get("disorder")){
				this.setDisOrder(null);
			}else{
				this.setDisOrder((Integer)map.get("disorder"));
			}
		}
		if(map.containsKey("remark")){
			if(null==map.get("remark")){
				this.setRemark(null);
			}else{
				this.setRemark((String)map.get("remark"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("TDeptInfoPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("code").append(" = ").append(this.getCode()).append(sep);
		sb.append("level").append(" = ").append(this.getLevel()).append(sep);
		sb.append("deptUrl").append(" = ").append(this.getDeptUrl()).append(sep);
		sb.append("deptUrlType").append(" = ").append(this.getDeptUrlType()).append(sep);
		sb.append("icoPath").append(" = ").append(this.getIcoPath()).append(sep);
		sb.append("valid").append(" = ").append(this.getValid()).append(sep);
		sb.append("orgId").append(" = ").append(this.getOrgId()).append(sep);
		sb.append("synopsis").append(" = ").append(this.getSynopsis()).append(sep);
		sb.append("specialty").append(" = ").append(this.getSpecialty()).append(sep);
		sb.append("team").append(" = ").append(this.getTeam()).append(sep);
		sb.append("equipment").append(" = ").append(this.getEquipment()).append(sep);
		sb.append("achievements").append(" = ").append(this.getAchievements()).append(sep);
		sb.append("disOrder").append(" = ").append(this.getDisOrder()).append(sep);
		sb.append("remark").append(" = ").append(this.getRemark()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}