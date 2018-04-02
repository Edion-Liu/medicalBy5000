<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixingpay.common.service.AbstractService;
import com.suixingpay.common.orm.dao.GenericDao;
import com.${vars.company}.${vars.project}.orm.domain.${class?cap_first};
import com.${vars.company}.${vars.project}.orm.mapper.${class?cap_first}Mapper;
import com.${vars.company}.${vars.project}.service.${class?cap_first}Service;
/**
 * Description: ${model.tabComment} Service
 <#if vars.company??>
 * Copyright: ?${date?string("yyyy")} ${vars.company}. All rights reserved.
 </#if>
 <#if vars.developer??>
 * @author ${vars.developer}
 </#if>
 * Created on: ${date?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service
public class ${class}ServiceImpl extends AbstractService<${class}, Serializable> implements ${class}Service{
	@Autowired
	private ${class}Mapper ${class?uncap_first}Mapper;
	
	@Override
	protected GenericDao<${class}, Serializable> getDao() {
		// TODO Auto-generated method stub
		return ${class?uncap_first}Mapper;
	}
}