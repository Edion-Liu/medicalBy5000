package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_docter Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-04 23:40:58
 */
public class DocterPo extends AbstractPo{
	// id
	private	String	id;
	// 姓名
	private	String	name;
	// 职称
	private	String	title;
	// 职务
	private	String	position;
	// 年龄
	private	Integer	age;
	// 性别
	private	String	sex;
	// 相片路径
	private	String	photoPath;
	// 联系电话
	private	String	tel;
	// 级别，共五级
	private	Integer	level;
	// 备注
	private	String	remark;
	// 所属部门
	private	String	orgId;
	// 所属组织
	private	String	unit;

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
	 * 姓名
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 职称
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 职务
	 * @return
	 */
	public String getPosition() {
		return position;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 年龄
	 * @return
	 */
	public Integer getAge() {
		return age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * 相片路径
	 * @return
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 联系电话
	 * @return
	 */
	public String getTel() {
		return tel;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 级别，共五级
	 * @return
	 */
	public Integer getLevel() {
		return level;
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

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 所属部门
	 * @return
	 */
	public String getOrgId() {
		return orgId;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 所属组织
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
}