package com.chuangbu.rpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.rpc.dao.StatisticalDao;
import com.chuangbu.rpc.pojo.Bar;
import com.chuangbu.rpc.pojo.Pie;

/**   
* @Title: DrugService.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午6:13:59 
* @version V1.0   
*/
@Service
public class StatisticalService {

	@Autowired
	StatisticalDao statisticalDao;
	
	public List<Pie> getIncomeData() {
		return statisticalDao.getIncomeData();
	}
	public List<Bar> getInoutData() {
		return statisticalDao.getInoutData();
	}
	public List<Bar> getWeekIncomeData() {
		return statisticalDao.getWeekIncomeData();
	}
}
