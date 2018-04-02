package com.chuangbu.core.service.hospital;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.core.orm.hospital.domain.TDocterInfo;
import com.chuangbu.core.orm.hospital.mapper.TDocterInfoMapper;

/**
 * Description: t_docter_info Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:49
 */
@Service
public class TDocterInfoService extends AbstractService<TDocterInfo,Serializable>{

	@Autowired
	TDocterInfoMapper mapper;
	
	@Override
	protected GenericDao<TDocterInfo, Serializable> getDao() {
		return mapper;
	}

	public List<TDocterInfo> findMainInfo(TDocterInfo docter) {
		return mapper.findMainInfo(docter);
	}
	
}