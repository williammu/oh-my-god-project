package com.projectK.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface CrudDao<T> {

	void save(T t);

	void update(T t);

	void saveOrUpdate(T t);

	void delete(T t);

	T getById(int id);
	T getBySysId(String sysId);

	T loadById(Long id);
	T loadBySysId(String sysId);

	List<T> queryCriteria(DetachedCriteria criteria);
	
	List<T> queryHql(String Hql);
	
	List<T> queryAll();

}
