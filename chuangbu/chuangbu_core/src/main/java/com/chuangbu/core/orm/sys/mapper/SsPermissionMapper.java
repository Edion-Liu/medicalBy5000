package com.chuangbu.core.orm.sys.mapper;

import java.io.Serializable;
import java.util.List;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.core.orm.sys.domain.SsPermission;

/**
 * Description: ss_permission Mapper
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-26 10:17:52
 */
public interface SsPermissionMapper extends GenericDao<SsPermission, Serializable> {
	
	public abstract List<SsPermission> findMenuAll();
	
}