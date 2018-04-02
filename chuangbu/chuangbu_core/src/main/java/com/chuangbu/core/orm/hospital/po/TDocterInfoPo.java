package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_docter_info Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:49
 */
public class TDocterInfoPo extends AbstractPo{
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
	// 所属科室id
	private	String	deptId;
	// 科室名称
	private	String	deptName;
	// 页面url
	private	String	pageUrl;
	// 页面url类型
	private	String	pageUrlType;
	// 所属部门
	private	String	orgId;
	// 所属组织
	private	String	unit;
	// 网上挂号；0不可以，1可以；默认为0
	private	Integer	olRegister;
	// 是否有效
	private	Short	valid;
	// 擅长
	private	String	specialty;
	// 简介
	private	String	synopsis;
	// 出诊信息
	private	String	visitInfo;
	// 科研成果
	private	String	achievements;
	// 发表文章
	private	String	publishAnArticle;
	// 显示顺序
	private	Integer	disOrder;

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

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 所属科室id
	 * @return
	 */
	public String getDeptId() {
		return deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 科室名称
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * 页面url
	 * @return
	 */
	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrlType(String pageUrlType) {
		this.pageUrlType = pageUrlType;
	}
	/**
	 * 页面url类型
	 * @return
	 */
	public String getPageUrlType() {
		return pageUrlType;
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

	public void setOlRegister(Integer olRegister) {
		this.olRegister = olRegister;
	}
	/**
	 * 网上挂号；0不可以，1可以；默认为0
	 * @return
	 */
	public Integer getOlRegister() {
		return olRegister;
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

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	/**
	 * 擅长
	 * @return
	 */
	public String getSpecialty() {
		return specialty;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * 简介
	 * @return
	 */
	public String getSynopsis() {
		return synopsis;
	}

	public void setVisitInfo(String visitInfo) {
		this.visitInfo = visitInfo;
	}
	/**
	 * 出诊信息
	 * @return
	 */
	public String getVisitInfo() {
		return visitInfo;
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

	public void setPublishAnArticle(String publishAnArticle) {
		this.publishAnArticle = publishAnArticle;
	}
	/**
	 * 发表文章
	 * @return
	 */
	public String getPublishAnArticle() {
		return publishAnArticle;
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
}