package com.chuangbu.core.service.sys;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.core.orm.sys.domain.SysDictType;
import com.chuangbu.core.orm.sys.mapper.SysDictTypeMapper;

/**
 * Description: sys_dict_type Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-25 21:42:37
 */
@Service
public class SysDictTypeService extends AbstractService<SysDictType,Serializable>{

	@Autowired
	SysDictTypeMapper mapper;
	
	@Override
	protected GenericDao<SysDictType, Serializable> getDao() {
		return mapper;
	}
	
}