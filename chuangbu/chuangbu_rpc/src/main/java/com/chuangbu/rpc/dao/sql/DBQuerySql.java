package com.chuangbu.rpc.dao.sql;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.chuangbu.common.util.des3.Des3Util;

/**   
* @Title: SqlConfig.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月4日 下午10:20:09 
* @version V1.0   
*/
@Configuration
@PropertySource("classpath:/config/querysql.properties")
@ConfigurationProperties(prefix = "db.query")
public class DBQuerySql {
	private String isEncry ;
	private String drugData ;
	private String treatmentData;
	private String incomeData ;
	private String inoutData;
	private String weekIncomeData;
	
	public Boolean isEncry() {
		return StringUtils.isNotBlank(isEncry) && "true".equals(isEncry) ? true : false;
	}
	
	public String getIsEncry() {
		return isEncry;
	}
	public void setIsEncry(String isEncry) {
		this.isEncry = isEncry;
	}
	public String getDrugData() {
		return isEncry()?Des3Util.decode(drugData) : drugData;
	}
	public void setDrugData(String drugData) {
		this.drugData = drugData;
	}
	public String getTreatmentData() {
		return isEncry()?Des3Util.decode(treatmentData) : treatmentData;
	}
	public void setTreatmentData(String treatmentData) {
		this.treatmentData = treatmentData;
	}
	public String getIncomeData() {
		return isEncry()?Des3Util.decode(incomeData) : incomeData;
	}
	public void setIncomeData(String incomeData) {
		this.incomeData = incomeData;
	}
	public String getInoutData() {
		return isEncry()?Des3Util.decode(inoutData) : inoutData;
	}
	public void setInoutData(String inoutData) {
		this.inoutData = inoutData;
	}
	public String getWeekIncomeData() {
		return isEncry()?Des3Util.decode(weekIncomeData) : weekIncomeData;
	}
	public void setWeekIncomeData(String weekIncomeData) {
		this.weekIncomeData = weekIncomeData;
	}
}
