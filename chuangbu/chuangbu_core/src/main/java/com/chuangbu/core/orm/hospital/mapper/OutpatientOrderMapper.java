package com.chuangbu.core.orm.hospital.mapper;

import java.io.Serializable;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.core.orm.hospital.domain.OutpatientOrder;

/**
 * Description: t_outpatient_order Mapper
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-08-27 23:27:55
 */
public interface OutpatientOrderMapper extends GenericDao<OutpatientOrder, Serializable> {

	void updateByOutpatientNo(OutpatientOrder po);

}