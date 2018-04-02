package com.chuangbu.core.orm.hospital.po;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: t_followup_record_log Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-16 21:58:22
 */
public class FollowUpRecordLogPo extends AbstractPo{
	// id
	private	String	id;
	// name
	private	String	name;
	// 类型；01，电话录音；02微信录音，默认01
	private	String	type;
	// docter_id
	private	String	docterId;
	// docter_name
	private	String	docterName;
	// patient_id
	private	String	patientId;
	// patient_name
	private	String	patientName;
	// path
	private	String	path;
	// ct
	private	Timestamp	ct;

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

	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 类型；01，电话录音；02微信录音，默认01
	 * @return
	 */
	public String getType() {
		return type;
	}

	public void setDocterId(String docterId) {
		this.docterId = docterId;
	}
	/**
	 * docter_id
	 * @return
	 */
	public String getDocterId() {
		return docterId;
	}

	public void setDocterName(String docterName) {
		this.docterName = docterName;
	}
	/**
	 * docter_name
	 * @return
	 */
	public String getDocterName() {
		return docterName;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * patient_id
	 * @return
	 */
	public String getPatientId() {
		return patientId;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * patient_name
	 * @return
	 */
	public String getPatientName() {
		return patientName;
	}

	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * path
	 * @return
	 */
	public String getPath() {
		return path;
	}

	public void setCt(Timestamp ct) {
		this.ct = ct;
	}
	/**
	 * ct
	 * @return
	 */
	public Timestamp getCt() {
		return ct;
	}
}