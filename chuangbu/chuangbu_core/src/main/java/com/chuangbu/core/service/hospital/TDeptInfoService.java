package com.chuangbu.core.service.hospital;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.core.orm.hospital.domain.TDeptInfo;
import com.chuangbu.core.orm.hospital.mapper.TDeptInfoMapper;

/**
 * Description: t_dept_info Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:25
 */
@Service
public class TDeptInfoService extends AbstractService<TDeptInfo,Serializable>{

	@Autowired
	TDeptInfoMapper mapper;
	
	@Override
	protected GenericDao<TDeptInfo, Serializable> getDao() {
		return mapper;
	}

	public List<TDeptInfo> findMainInfo(TDeptInfo dept) {
		return mapper.findMainInfo(dept);
	}
	
}