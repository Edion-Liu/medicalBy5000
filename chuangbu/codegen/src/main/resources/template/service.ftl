<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.service.${vars.module};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import com.${vars.company}.${vars.project}.orm.${vars.module}.domain.${class?cap_first};
import com.${vars.company}.${vars.project}.orm.${vars.module}.mapper.${class?cap_first}Mapper;
import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;

/**
 * Description: ${model.tabComment} Service
 <#if vars.company??>
 * Copyright: ©${date?string("yyyy")} ${vars.company}. All rights reserved.
 </#if>
 <#if vars.developer??>
 * @author ${vars.developer}
 </#if>
 * Created on: ${date?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service
public class ${class}Service extends AbstractService<${class?cap_first},Serializable>{

	@Autowired
	${class?cap_first}Mapper mapper;
	
	@Override
	protected GenericDao<${class?cap_first}, Serializable> getDao() {
		return mapper;
	}
	
}