package com.chuangbu.core.orm.sys.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: ss_role Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 14:28:23
 */
public class SsRolePo extends AbstractPo{
	// id
	private	String	id;
	// name
	private	String	name;
	// note
	private	String	note;

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
	 * name
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * note
	 * @return
	 */
	public String getNote() {
		return note;
	}
}