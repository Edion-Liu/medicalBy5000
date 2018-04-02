package com.chuangbu.core.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.sys.domain.SysDictItem;
import com.chuangbu.core.orm.sys.mapper.SysDictItemMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: sys_dict_item Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-03-11 22:50:46
 */
@Service
public class SysDictItemService extends AbstractService<SysDictItem,Serializable>{

	@Autowired
	SysDictItemMapper mapper;
	
	@Override
	protected GenericDao<SysDictItem, Serializable> getDao() {
		return mapper;
	}
	
}