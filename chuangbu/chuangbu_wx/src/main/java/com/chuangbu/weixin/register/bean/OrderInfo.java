package com.chuangbu.weixin.register.bean;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月30日 下午2:43:02
 */

public class OrderInfo implements Body {

	private String DeptCode;
	private String DoctorCode;
	private String VisitDate;
	private String VisitTime;
	private String VisitFlag;
	private String VisitType;
	private String SumFee;
	private String PatientType;
	
	public String getDeptCode() {
		return DeptCode;
	}
	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}
	public String getDoctorCode() {
		return DoctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		DoctorCode = doctorCode;
	}
	public String getVisitDate() {
		return VisitDate;
	}
	public void setVisitDate(String visitDate) {
		VisitDate = visitDate;
	}
	public String getVisitTime() {
		return VisitTime;
	}
	public void setVisitTime(String visitTime) {
		VisitTime = visitTime;
	}
	public String getVisitFlag() {
		return VisitFlag;
	}
	public void setVisitFlag(String visitFlag) {
		VisitFlag = visitFlag;
	}
	public String getVisitType() {
		return VisitType;
	}
	public void setVisitType(String visitType) {
		VisitType = visitType;
	}
	public String getSumFee() {
		return SumFee;
	}
	public void setSumFee(String sumFee) {
		SumFee = sumFee;
	}
	public String getPatientType() {
		return PatientType;
	}
	public void setPatientType(String patientType) {
		PatientType = patientType;
	}
	
}
