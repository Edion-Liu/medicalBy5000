package com.chuangbu.core.orm.sys.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: ss_permission Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-26 10:17:51
 */
public class SsPermissionPo extends AbstractPo{
	// id
	private	String	id;
	// expanded_
	private	String	expanded;
	// leaf_
	private	Short	leaf;
	// level_
	private	Integer	level;
	// loaded_
	private	String	loaded;
	// order_
	private	Double	order;
	// display_name
	private	String	displayName;
	// iconname
	private	String	iconname;
	// menu
	private	Short	menu;
	// name
	private	String	name;
	// url
	private	String	url;
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

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}
	/**
	 * expanded_
	 * @return
	 */
	public String getExpanded() {
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

	public void setLoaded(String loaded) {
		this.loaded = loaded;
	}
	/**
	 * loaded_
	 * @return
	 */
	public String getLoaded() {
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

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * display_name
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	public void setIconname(String iconname) {
		this.iconname = iconname;
	}
	/**
	 * iconname
	 * @return
	 */
	public String getIconname() {
		return iconname;
	}

	public void setMenu(Short menu) {
		this.menu = menu;
	}
	/**
	 * menu
	 * @return
	 */
	public Short getMenu() {
		return menu;
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

	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * url
	 * @return
	 */
	public String getUrl() {
		return url;
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