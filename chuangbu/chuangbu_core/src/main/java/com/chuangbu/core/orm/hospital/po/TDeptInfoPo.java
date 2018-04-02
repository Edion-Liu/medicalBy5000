package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_dept_info Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:25
 */
public class TDeptInfoPo extends AbstractPo{
	// id
	private	String	id;
	// 科室名称
	private	String	name;
	// 科室编码
	private	String	code;
	// 科室级别
	private	Integer	level;
	// 科室url
	private	String	deptUrl;
	// 科室url类型
	private	String	deptUrlType;
	// 图标路径
	private	String	icoPath;
	// 是否有效
	private	Short	valid;
	// 组织id
	private	String	orgId;
	// 科室简介
	private	String	synopsis;
	// 科室擅长
	private	String	specialty;
	// 团队组成
	private	String	team;
	// 先进设备
	private	String	equipment;
	// 科研成果
	private	String	achievements;
	// 显示顺序
	private	Integer	disOrder;
	// 备注
	private	String	remark;

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

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 科室名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 科室编码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 科室级别
	 * @return
	 */
	public Integer getLevel() {
		return level;
	}

	public void setDeptUrl(String deptUrl) {
		this.deptUrl = deptUrl;
	}
	/**
	 * 科室url
	 * @return
	 */
	public String getDeptUrl() {
		return deptUrl;
	}

	public void setDeptUrlType(String deptUrlType) {
		this.deptUrlType = deptUrlType;
	}
	/**
	 * 科室url类型
	 * @return
	 */
	public String getDeptUrlType() {
		return deptUrlType;
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
	 * 组织id
	 * @return
	 */
	public String getOrgId() {
		return orgId;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * 科室简介
	 * @return
	 */
	public String getSynopsis() {
		return synopsis;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	/**
	 * 科室擅长
	 * @return
	 */
	public String getSpecialty() {
		return specialty;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * 团队组成
	 * @return
	 */
	public String getTeam() {
		return team;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	/**
	 * 先进设备
	 * @return
	 */
	public String getEquipment() {
		return equipment;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	/**
	 * 科研成果
	 * @return
	 */
	public String getAchievements() {
		return achievements;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
}