package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.TDocterInfoPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_docter_info Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:49
 */
public class TDocterInfo extends TDocterInfoPo implements Domain {

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
			
		if(this.getOlRegister() == null)
			sb.append("网上挂号；0不可以，1可以；默认为0不能为空！");
		
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
			
		if(this.getDeptId().getBytes().length > 96)
			sb.append("所属科室id宽度不能超过96个字符！");
			
		if(this.getDeptName().getBytes().length > 150)
			sb.append("科室名称宽度不能超过150个字符！");
			
		if(this.getPageUrl().getBytes().length > 300)
			sb.append("页面url宽度不能超过300个字符！");
			
		if(this.getPageUrlType().getBytes().length > 6)
			sb.append("页面url类型宽度不能超过6个字符！");
			
		if(this.getOrgId().getBytes().length > 96)
			sb.append("所属部门宽度不能超过96个字符！");
			
		if(this.getUnit().getBytes().length > 60)
			sb.append("所属组织宽度不能超过60个字符！");
			
		if(this.getSpecialty().getBytes().length > 3000)
			sb.append("擅长宽度不能超过3,000个字符！");
			
		if(this.getSynopsis().getBytes().length > 3000)
			sb.append("简介宽度不能超过3,000个字符！");
			
		if(this.getVisitInfo().getBytes().length > 1500)
			sb.append("出诊信息宽度不能超过1,500个字符！");
			
		if(this.getAchievements().getBytes().length > 3000)
			sb.append("科研成果宽度不能超过3,000个字符！");
			
		if(this.getPublishAnArticle().getBytes().length > 1500)
			sb.append("发表文章宽度不能超过1,500个字符！");
			
		String msg = sb.toString();
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
			map.put("deptid",this.getDeptId());
			map.put("deptname",this.getDeptName());
			map.put("pageurl",this.getPageUrl());
			map.put("pageurltype",this.getPageUrlType());
			map.put("orgid",this.getOrgId());
			map.put("unit",this.getUnit());
			map.put("olregister",this.getOlRegister());
			map.put("valid",this.getValid());
			map.put("specialty",this.getSpecialty());
			map.put("synopsis",this.getSynopsis());
			map.put("visitinfo",this.getVisitInfo());
			map.put("achievements",this.getAchievements());
			map.put("publishanarticle",this.getPublishAnArticle());
			map.put("disorder",this.getDisOrder());
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
		if(map.containsKey("deptid")){
			if(null==map.get("deptid")){
				this.setDeptId(null);
			}else{
				this.setDeptId((String)map.get("deptid"));
			}
		}
		if(map.containsKey("deptname")){
			if(null==map.get("deptname")){
				this.setDeptName(null);
			}else{
				this.setDeptName((String)map.get("deptname"));
			}
		}
		if(map.containsKey("pageurl")){
			if(null==map.get("pageurl")){
				this.setPageUrl(null);
			}else{
				this.setPageUrl((String)map.get("pageurl"));
			}
		}
		if(map.containsKey("pageurltype")){
			if(null==map.get("pageurltype")){
				this.setPageUrlType(null);
			}else{
				this.setPageUrlType((String)map.get("pageurltype"));
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
		if(map.containsKey("olregister")){
			if(null==map.get("olregister")){
				this.setOlRegister(null);
			}else{
				this.setOlRegister((Integer)map.get("olregister"));
			}
		}
		if(map.containsKey("valid")){
			if(null==map.get("valid")){
				this.setValid(null);
			}else{
				this.setValid((Short)map.get("valid"));
			}
		}
		if(map.containsKey("specialty")){
			if(null==map.get("specialty")){
				this.setSpecialty(null);
			}else{
				this.setSpecialty((String)map.get("specialty"));
			}
		}
		if(map.containsKey("synopsis")){
			if(null==map.get("synopsis")){
				this.setSynopsis(null);
			}else{
				this.setSynopsis((String)map.get("synopsis"));
			}
		}
		if(map.containsKey("visitinfo")){
			if(null==map.get("visitinfo")){
				this.setVisitInfo(null);
			}else{
				this.setVisitInfo((String)map.get("visitinfo"));
			}
		}
		if(map.containsKey("achievements")){
			if(null==map.get("achievements")){
				this.setAchievements(null);
			}else{
				this.setAchievements((String)map.get("achievements"));
			}
		}
		if(map.containsKey("publishanarticle")){
			if(null==map.get("publishanarticle")){
				this.setPublishAnArticle(null);
			}else{
				this.setPublishAnArticle((String)map.get("publishanarticle"));
			}
		}
		if(map.containsKey("disorder")){
			if(null==map.get("disorder")){
				this.setDisOrder(null);
			}else{
				this.setDisOrder((Integer)map.get("disorder"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("TDocterInfoPo").append(sep);
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
		sb.append("deptId").append(" = ").append(this.getDeptId()).append(sep);
		sb.append("deptName").append(" = ").append(this.getDeptName()).append(sep);
		sb.append("pageUrl").append(" = ").append(this.getPageUrl()).append(sep);
		sb.append("pageUrlType").append(" = ").append(this.getPageUrlType()).append(sep);
		sb.append("orgId").append(" = ").append(this.getOrgId()).append(sep);
		sb.append("unit").append(" = ").append(this.getUnit()).append(sep);
		sb.append("olRegister").append(" = ").append(this.getOlRegister()).append(sep);
		sb.append("valid").append(" = ").append(this.getValid()).append(sep);
		sb.append("specialty").append(" = ").append(this.getSpecialty()).append(sep);
		sb.append("synopsis").append(" = ").append(this.getSynopsis()).append(sep);
		sb.append("visitInfo").append(" = ").append(this.getVisitInfo()).append(sep);
		sb.append("achievements").append(" = ").append(this.getAchievements()).append(sep);
		sb.append("publishAnArticle").append(" = ").append(this.getPublishAnArticle()).append(sep);
		sb.append("disOrder").append(" = ").append(this.getDisOrder()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}