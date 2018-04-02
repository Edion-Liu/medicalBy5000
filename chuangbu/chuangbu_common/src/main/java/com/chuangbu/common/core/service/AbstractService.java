package com.chuangbu.common.core.service;

import java.io.Serializable;
import java.util.List;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.orm.domain.Domain;

/**
 * @Title: AbstractService.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月25日 下午9:50:10
 * @version V1.0
 */
public abstract class AbstractService<T extends Domain, ID extends Serializable> implements GenericService<T, ID> {
	protected abstract GenericDao<T, ID> getDao();

	public void save(T entity) {
		getDao().save(entity);
	}

	public int update(T entity) {
		return getDao().update(entity);
	}

	public void delete(ID id) {
		getDao().delete(id);
	}

	public void deleteAll(List<ID> id) {
		getDao().deleteAll(id);
	}

	public T findOne(ID id) {
		return getDao().findOne(id);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

	public List<T> findAll(List<ID> ids) {
		return getDao().findAll(ids);
	}

	public List<T> find(T entity) {
		return getDao().find(entity);
	}

	public <O extends Number> O count(T entity) {
		return getDao().count(entity);
	}

}
