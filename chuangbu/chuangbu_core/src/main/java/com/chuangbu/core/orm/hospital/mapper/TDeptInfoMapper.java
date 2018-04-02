package com.chuangbu.core.orm.hospital.mapper;

import java.io.Serializable;
import java.util.List;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.core.orm.hospital.domain.TDeptInfo;

/**
 * Description: t_dept_info Mapper
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:00:25
 */
public interface TDeptInfoMapper extends GenericDao<TDeptInfo, Serializable> {

	List<TDeptInfo> findMainInfo(TDeptInfo dept);

}