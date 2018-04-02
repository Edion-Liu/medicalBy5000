package com.chuangbu.core.service.hospital;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.common.util.JSONUtil;
import com.chuangbu.core.constants.Constants;
import com.chuangbu.core.orm.hospital.domain.TOrgMenu;
import com.chuangbu.core.orm.hospital.mapper.TOrgMenuMapper;
import com.chuangbu.core.service.sys.ICacheService;
import com.chuangbu.core.service.sys.IRedisService;

/**
 * Description: t_org_menu Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 13:11:42
 */
@Service
public class TOrgMenuService extends AbstractService<TOrgMenu,Serializable>{

	@Autowired
	TOrgMenuMapper mapper;
	@Autowired
    private ICacheService cacheService;
	
	@Override
	protected GenericDao<TOrgMenu, Serializable> getDao() {
		return mapper;
	}
	
	public void initRedisMenu(TOrgMenu menu){
		menu.setParent("0");
		menu.setOrderBy(" dis_order ");
		menu.setValid((short) 1);
		cacheService.set(com.chuangbu.core.constants.Constants.ORG_MENU_KEY+"_"+menu.getOrgId(), JSONUtil.toJson(this.find(menu)));
	}
	
	public String getTOrgMenu(String appId){
		return cacheService.get(Constants.ORG_MENU_KEY+"_"+appId);
	}
}