<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.orm.${vars.module}.mapper;

import java.io.Serializable;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.${vars.company}.${vars.project}.orm.${vars.module}.domain.${class?cap_first};

/**
 * Description: ${model.tabComment} Mapper
 <#if vars.company??>
 * Copyright: ©${date?string("yyyy")} ${vars.company}. All rights reserved.
 </#if>
 <#if vars.developer??>
 * @author ${vars.developer}
 </#if>
 * Created on: ${date?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${class?cap_first}Mapper extends GenericDao<${class}, Serializable> {

}