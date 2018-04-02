package com.chuangbu.core.orm.sys.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: sys_dict_item Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-11 22:50:45
 */
public class SysDictItemPo extends AbstractPo{
	// id
	private	String	id;
	// expanded_
	private	Short	expanded;
	// leaf_
	private	Short	leaf;
	// level_
	private	Integer	level;
	// loaded_
	private	Short	loaded;
	// order_
	private	Double	order;
	// ename
	private	String	ename;
	// itemname
	private	String	itemname;
	// valid
	private	Short	valid;
	// parent_
	private	String	parent;
	// typeid
	private	String	typeid;

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * id
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setExpanded(Short expanded) {
		this.expanded = expanded;
	}
	/**
	 * expanded_
	 * @return
	 */
	public Short getExpanded() {
		return expanded;
	}

	public void setLeaf(Short leaf) {
		this.leaf = leaf;
	}
	/**
	 * leaf_
	 * @return
	 */
	public Short getLeaf() {
		return leaf;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * level_
	 * @return
	 */
	public Integer getLevel() {
		return level;
	}

	public void setLoaded(Short loaded) {
		this.loaded = loaded;
	}
	/**
	 * loaded_
	 * @return
	 */
	public Short getLoaded() {
		return loaded;
	}

	public void setOrder(Double order) {
		this.order = order;
	}
	/**
	 * order_
	 * @return
	 */
	public Double getOrder() {
		return order;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * ename
	 * @return
	 */
	public String getEname() {
		return ename;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	/**
	 * itemname
	 * @return
	 */
	public String getItemname() {
		return itemname;
	}

	public void setValid(Short valid) {
		this.valid = valid;
	}
	/**
	 * valid
	 * @return
	 */
	public Short getValid() {
		return valid;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * parent_
	 * @return
	 */
	public String getParent() {
		return parent;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	/**
	 * typeid
	 * @return
	 */
	public String getTypeid() {
		return typeid;
	}
}