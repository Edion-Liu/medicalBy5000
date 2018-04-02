package com.chuangbu.core.service.hospital;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.common.util.JSONUtil;
import com.chuangbu.core.constants.Constants;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.orm.hospital.mapper.TAppConfigMapper;
import com.chuangbu.core.service.sys.ICacheService;

/**
 * Description: t_app_config Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-10-04 22:07:28
 */
@Service
public class TAppConfigService extends AbstractService<TAppConfig,Serializable>{

	@Autowired
	TAppConfigMapper mapper;
	@Autowired
    private ICacheService cacheService;
	
	@Override
	protected GenericDao<TAppConfig, Serializable> getDao() {
		return mapper;
	}
	
	public void initRedisTAppConfig(){
		List<TAppConfig> confs = this.findAll();
    	for(TAppConfig conf : confs){
    		cacheService.set(Constants.ORG_APP_CONFIG+"_"+conf.getAppId(), JSONUtil.toJson(conf));
    	}
	}
	

	public TAppConfig getTAppConfig(String appId){
		String confStr = cacheService.get(Constants.ORG_APP_CONFIG+"_"+appId);
		if(StringUtils.isBlank(confStr)){
			TAppConfig config = new TAppConfig();
			config.setAppId(appId);
			List<TAppConfig> confs = this.findAll();
			if(confs.size()>0){
				cacheService.set(Constants.ORG_APP_CONFIG+"_"+appId, JSONUtil.toJson(confs.get(0)));
			}
		}
		return JSONUtil.toBean(confStr, TAppConfig.class);
	}

	public void cleanAll() {
		cacheService.cleanAll();
	}

}