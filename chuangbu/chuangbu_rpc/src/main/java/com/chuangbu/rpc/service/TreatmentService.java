package com.chuangbu.rpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.rpc.dao.TreatmentDao;
import com.chuangbu.rpc.pojo.Drug;
import com.chuangbu.rpc.pojo.Treatment;

/**   
* @Title: DrugService.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午6:13:59 
* @version V1.0   
*/
@Service
public class TreatmentService {

	@Autowired
	TreatmentDao treatmentDao;
	public List<Treatment> findAll() {
		return treatmentDao.findAll();
	}
	
	public List<Treatment> findByGeneralName(String generalName) {
		return treatmentDao.findByGeneralName(generalName);
	}
}
