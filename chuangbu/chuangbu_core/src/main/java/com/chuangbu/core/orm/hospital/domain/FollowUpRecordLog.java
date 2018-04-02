package com.chuangbu.core.orm.hospital.domain;

import java.util.*;
import java.sql.Timestamp;
import com.chuangbu.core.orm.hospital.po.FollowUpRecordLogPo;
import com.chuangbu.common.core.orm.domain.Domain;
/**
 * Description: t_followup_record_log Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-16 21:58:23
 */
public class FollowUpRecordLog extends FollowUpRecordLogPo implements Domain {

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
			sb.append("name宽度不能超过150个字符！");
			
		if(this.getType().getBytes().length > 6)
			sb.append("类型；01，电话录音；02微信录音，默认01宽度不能超过6个字符！");
			
		if(this.getDocterId().getBytes().length > 96)
			sb.append("docter_id宽度不能超过96个字符！");
			
		if(this.getDocterName().getBytes().length > 90)
			sb.append("docter_name宽度不能超过90个字符！");
			
		if(this.getPatientId().getBytes().length > 96)
			sb.append("patient_id宽度不能超过96个字符！");
			
		if(this.getPatientName().getBytes().length > 90)
			sb.append("patient_name宽度不能超过90个字符！");
			
		if(this.getPath().getBytes().length > 240)
			sb.append("path宽度不能超过240个字符！");
			
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
			map.put("type",this.getType());
			map.put("docterid",this.getDocterId());
			map.put("doctername",this.getDocterName());
			map.put("patientid",this.getPatientId());
			map.put("patientname",this.getPatientName());
			map.put("path",this.getPath());
			map.put("ct",this.getCt());
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
		if(map.containsKey("type")){
			if(null==map.get("type")){
				this.setType(null);
			}else{
				this.setType((String)map.get("type"));
			}
		}
		if(map.containsKey("docterid")){
			if(null==map.get("docterid")){
				this.setDocterId(null);
			}else{
				this.setDocterId((String)map.get("docterid"));
			}
		}
		if(map.containsKey("doctername")){
			if(null==map.get("doctername")){
				this.setDocterName(null);
			}else{
				this.setDocterName((String)map.get("doctername"));
			}
		}
		if(map.containsKey("patientid")){
			if(null==map.get("patientid")){
				this.setPatientId(null);
			}else{
				this.setPatientId((String)map.get("patientid"));
			}
		}
		if(map.containsKey("patientname")){
			if(null==map.get("patientname")){
				this.setPatientName(null);
			}else{
				this.setPatientName((String)map.get("patientname"));
			}
		}
		if(map.containsKey("path")){
			if(null==map.get("path")){
				this.setPath(null);
			}else{
				this.setPath((String)map.get("path"));
			}
		}
		if(map.containsKey("ct")){
			if(null==map.get("ct")){
				this.setCt(null);
			}else{
				this.setCt((Timestamp)map.get("ct"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("FollowUpRecordLogPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("name").append(" = ").append(this.getName()).append(sep);
		sb.append("type").append(" = ").append(this.getType()).append(sep);
		sb.append("docterId").append(" = ").append(this.getDocterId()).append(sep);
		sb.append("docterName").append(" = ").append(this.getDocterName()).append(sep);
		sb.append("patientId").append(" = ").append(this.getPatientId()).append(sep);
		sb.append("patientName").append(" = ").append(this.getPatientName()).append(sep);
		sb.append("path").append(" = ").append(this.getPath()).append(sep);
		sb.append("ct").append(" = ").append(this.getCt()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}