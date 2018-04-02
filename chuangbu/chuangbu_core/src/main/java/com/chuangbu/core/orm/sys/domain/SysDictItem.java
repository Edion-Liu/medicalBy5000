package com.chuangbu.core.orm.sys.domain;

import java.util.HashMap;
import java.util.Map;

import com.chuangbu.common.core.orm.domain.Domain;
import com.chuangbu.core.orm.sys.po.SysDictItemPo;
/**
 * Description: sys_dict_item Domain
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-11 22:50:46
 */
public class SysDictItem extends SysDictItemPo implements Domain {

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
			
		if(this.getEname().getBytes().length > 120)
			sb.append("ename宽度不能超过120个字符！");
			
		if(this.getItemname().getBytes().length > 300)
			sb.append("itemname宽度不能超过300个字符！");
			
		if(this.getParent().getBytes().length > 96)
			sb.append("parent_宽度不能超过96个字符！");
			
		if(this.getTypeid().getBytes().length > 96)
			sb.append("typeid宽度不能超过96个字符！");
			
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
			map.put("ename",this.getEname());
			map.put("itemname",this.getItemname());
			map.put("valid",this.getValid());
			map.put("parent",this.getParent());
			map.put("typeid",this.getTypeid());
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
				this.setExpanded((Short)map.get("expanded"));
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
				this.setLoaded((Short)map.get("loaded"));
			}
		}
		if(map.containsKey("order")){
			if(null==map.get("order")){
				this.setOrder(null);
			}else{
				this.setOrder((Double)map.get("order"));
			}
		}
		if(map.containsKey("ename")){
			if(null==map.get("ename")){
				this.setEname(null);
			}else{
				this.setEname((String)map.get("ename"));
			}
		}
		if(map.containsKey("itemname")){
			if(null==map.get("itemname")){
				this.setItemname(null);
			}else{
				this.setItemname((String)map.get("itemname"));
			}
		}
		if(map.containsKey("valid")){
			if(null==map.get("valid")){
				this.setValid(null);
			}else{
				this.setValid((Short)map.get("valid"));
			}
		}
		if(map.containsKey("parent")){
			if(null==map.get("parent")){
				this.setParent(null);
			}else{
				this.setParent((String)map.get("parent"));
			}
		}
		if(map.containsKey("typeid")){
			if(null==map.get("typeid")){
				this.setTypeid(null);
			}else{
				this.setTypeid((String)map.get("typeid"));
			}
		}
	}
	
	 /**
	  * Returns a string representation of the object.
	  */
	 public String toString(){
	 	String sep = "; ";
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("SysDictItemPo").append(sep);
		sb.append("id").append(" = ").append(this.getId()).append(sep);
		sb.append("expanded").append(" = ").append(this.getExpanded()).append(sep);
		sb.append("leaf").append(" = ").append(this.getLeaf()).append(sep);
		sb.append("level").append(" = ").append(this.getLevel()).append(sep);
		sb.append("loaded").append(" = ").append(this.getLoaded()).append(sep);
		sb.append("order").append(" = ").append(this.getOrder()).append(sep);
		sb.append("ename").append(" = ").append(this.getEname()).append(sep);
		sb.append("itemname").append(" = ").append(this.getItemname()).append(sep);
		sb.append("valid").append(" = ").append(this.getValid()).append(sep);
		sb.append("parent").append(" = ").append(this.getParent()).append(sep);
		sb.append("typeid").append(" = ").append(this.getTypeid()).append(sep);
		return sb.toString();
	 
	 }
	 
	
}