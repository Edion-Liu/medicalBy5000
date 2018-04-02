package com.chuangbu.core.orm.hospital.mapper;

import java.io.Serializable;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.core.orm.hospital.domain.RegisterOrder;
import com.chuangbu.core.orm.hospital.po.RegisterOrderPo;

/**
 * Description: t_register_order Mapper
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-06-11 23:28:42
 */
public interface RegisterOrderMapper extends GenericDao<RegisterOrder, Serializable> {

	public void updateByOutTradeNo(RegisterOrderPo po);
	
	public int findByOpenIdAndDayCount(RegisterOrderPo po);
	
}