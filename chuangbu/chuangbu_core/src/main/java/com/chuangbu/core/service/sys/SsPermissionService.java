package com.chuangbu.core.service.sys;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.core.orm.sys.domain.SsPermission;
import com.chuangbu.core.orm.sys.mapper.SsPermissionMapper;

/**
 * Description: ss_permission Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-26 10:17:52
 */
@Service
public class SsPermissionService extends AbstractService<SsPermission,Serializable>{

	@Autowired
	SsPermissionMapper mapper;
	
	@Override
	protected GenericDao<SsPermission, Serializable> getDao() {
		return mapper;
	}
	
}