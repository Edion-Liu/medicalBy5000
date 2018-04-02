package com.chuangbu.core.orm.sys.po;

import java.util.Date;

import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: ss_user Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 15:10:49
 */
public class SsUserPo extends AbstractPo{
	// id
	private	String	id;
	// login_name
	private	String	loginName;
	// name
	private	String	name;
	// password
	private	String	password;
	// salt
	private	String	salt;
	// createtime
	private	Date	createtime;
	// email
	private	String	email;
	// status
	private	String	status;
	// locked
	private	Long	locked;

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

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * login_name
	 * @return
	 */
	public String getLoginName() {
		return loginName;
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

	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * salt
	 * @return
	 */
	public String getSalt() {
		return salt;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * createtime
	 * @return
	 */
	public Date getCreatetime() {
		return createtime;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * status
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	public void setLocked(Long locked) {
		this.locked = locked;
	}
	/**
	 * locked
	 * @return
	 */
	public Long getLocked() {
		return locked;
	}
}