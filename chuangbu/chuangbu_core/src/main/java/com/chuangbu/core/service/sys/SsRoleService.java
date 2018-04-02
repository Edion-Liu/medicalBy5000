package com.chuangbu.core.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.sys.domain.SsRole;
import com.chuangbu.core.orm.sys.mapper.SsRoleMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: ss_role Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 14:28:23
 */
@Service
public class SsRoleService extends AbstractService<SsRole,Serializable>{

	@Autowired
	SsRoleMapper mapper;
	
	@Override
	protected GenericDao<SsRole, Serializable> getDao() {
		return mapper;
	}
	
}