package com.chuangbu.core.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.sys.domain.SysOrganization;
import com.chuangbu.core.orm.sys.mapper.SysOrganizationMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: sys_organization Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 13:22:22
 */
@Service
public class SysOrganizationService extends AbstractService<SysOrganization,Serializable>{

	@Autowired
	SysOrganizationMapper mapper;
	
	@Override
	protected GenericDao<SysOrganization, Serializable> getDao() {
		return mapper;
	}
	
}