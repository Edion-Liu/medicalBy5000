package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_org_menu Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 13:11:42
 */
public class TOrgMenuPo extends AbstractPo{
	// id
	private	String	id;
	// 菜单名称
	private	String	menuName;
	// 菜单编码
	private	String	menuCode;
	// 菜单路径
	private	String	menuUrl;
	// 图标路径
	private	String	icoPath;
	// 菜单级别
	private	Integer	level;
	// 显示顺序
	private	Integer	disOrder;
	// 父级菜单
	private	String	parent;
	// 是否有子节点
	private	Short	children;
	// 是否有效
	private	Short	valid;
	// 组织ID
	private	String	orgId;
	// 菜单类型
	private	String	menuType;

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

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 菜单名称
	 * @return
	 */
	public String getMenuName() {
		return menuName;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	/**
	 * 菜单编码
	 * @return
	 */
	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	/**
	 * 菜单路径
	 * @return
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setIcoPath(String icoPath) {
		this.icoPath = icoPath;
	}
	/**
	 * 图标路径
	 * @return
	 */
	public String getIcoPath() {
		return icoPath;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 菜单级别
	 * @return
	 */
	public Integer getLevel() {
		return level;
	}

	public void setDisOrder(Integer disOrder) {
		this.disOrder = disOrder;
	}
	/**
	 * 显示顺序
	 * @return
	 */
	public Integer getDisOrder() {
		return disOrder;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * 父级菜单
	 * @return
	 */
	public String getParent() {
		return parent;
	}

	public void setChildren(Short children) {
		this.children = children;
	}
	/**
	 * 是否有子节点
	 * @return
	 */
	public Short getChildren() {
		return children;
	}

	public void setValid(Short valid) {
		this.valid = valid;
	}
	/**
	 * 是否有效
	 * @return
	 */
	public Short getValid() {
		return valid;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 组织ID
	 * @return
	 */
	public String getOrgId() {
		return orgId;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	/**
	 * 菜单类型
	 * @return
	 */
	public String getMenuType() {
		return menuType;
	}
}