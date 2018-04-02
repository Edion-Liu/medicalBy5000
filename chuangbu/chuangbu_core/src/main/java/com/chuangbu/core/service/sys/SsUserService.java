package com.chuangbu.core.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.sys.domain.SsUser;
import com.chuangbu.core.orm.sys.mapper.SsUserMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: ss_user Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-12 15:10:49
 */
@Service
public class SsUserService extends AbstractService<SsUser,Serializable>{

	@Autowired
	SsUserMapper mapper;
	
	@Override
	protected GenericDao<SsUser, Serializable> getDao() {
		return mapper;
	}
	
}