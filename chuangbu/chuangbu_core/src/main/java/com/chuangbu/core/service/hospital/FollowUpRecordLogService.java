package com.chuangbu.core.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.chuangbu.core.orm.hospital.domain.FollowUpRecordLog;
import com.chuangbu.core.orm.hospital.mapper.FollowUpRecordLogMapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: t_followup_record_log Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-04-16 21:58:24
 */
@Service
public class FollowUpRecordLogService extends AbstractService<FollowUpRecordLog,Serializable>{

	@Autowired
	FollowUpRecordLogMapper mapper;
	
	@Override
	protected GenericDao<FollowUpRecordLog, Serializable> getDao() {
		return mapper;
	}
	
}