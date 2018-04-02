package com.chuangbu.core.orm.sys.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: sys_organization Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 13:22:21
 */
public class SysOrganizationPo extends AbstractPo{
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
	// code
	private	String	code;
	// name
	private	String	name;
	// parent_
	private	String	parent;

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

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * code
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * name
	 * @return
	 */
	public String getName() {
		return name;
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
}