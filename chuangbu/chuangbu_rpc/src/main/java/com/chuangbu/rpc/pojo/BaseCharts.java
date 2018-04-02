package com.chuangbu.rpc.pojo;

import java.math.BigDecimal;

/**   
* @Title: BaseCharts.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月19日 下午6:32:36 
* @version V1.0   
*/
public class BaseCharts {
	
	private String name;
	private BigDecimal value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
