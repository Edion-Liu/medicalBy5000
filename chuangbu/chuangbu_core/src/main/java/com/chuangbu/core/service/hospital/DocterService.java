package com.chuangbu.core.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.hospital.domain.Docter;
import com.chuangbu.core.orm.hospital.mapper.DocterMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: t_docter Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-04 23:40:59
 */
@Service
public class DocterService extends AbstractService<Docter,Serializable>{

	@Autowired
	DocterMapper mapper;
	
	@Override
	protected GenericDao<Docter, Serializable> getDao() {
		return mapper;
	}
	
}