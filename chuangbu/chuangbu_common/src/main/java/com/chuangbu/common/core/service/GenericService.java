package com.chuangbu.common.core.service;

import java.io.Serializable;
import java.util.List;

import com.chuangbu.common.core.orm.domain.Domain;

/**   
* @Title: GenericService.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月25日 下午9:51:01 
* @version V1.0   
*/

public abstract interface GenericService<T extends Domain, ID extends Serializable> 
{
  public abstract void save(T paramT);

  public abstract int update(T paramT);

  public abstract void delete(ID paramID);

  public abstract void deleteAll(List<ID> paramList);

  public abstract T findOne(ID paramID);

  public abstract List<T> findAll();

  public abstract List<T> findAll(List<ID> paramList);

  public abstract List<T> find(T paramT);

  public abstract <O extends Number> O count(T paramT);
}
