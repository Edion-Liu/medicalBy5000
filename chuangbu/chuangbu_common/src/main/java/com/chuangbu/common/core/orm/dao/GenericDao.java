package com.chuangbu.common.core.orm.dao;

import java.io.Serializable;
import java.util.List;

import com.chuangbu.common.core.orm.domain.Domain;
import com.chuangbu.common.core.service.GenericService;

/**   
* @Title: GenericDao.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月25日 下午9:48:16 
* @version V1.0   
*/
public abstract interface GenericDao<T extends Domain, ID extends Serializable> extends GenericService<T, ID>
{
  public abstract void save(T paramT);

  public abstract int update(T paramT);

  public abstract void delete(ID paramID);

  public abstract void deleteAll(List<ID> paramList);



}
