package com.projectK.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

@SuppressWarnings("unchecked")
public class BaseDaoSupport<T> extends BaseDao implements CrudDao<T> {
	public DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(getEntityClass());
	}

	public List<T> queryCriteria(DetachedCriteria criteria) {
		return findByCriteria(criteria);
	}

	public List<T> queryHql(String Hql) {
		return findByQuery(Hql);
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	public T getById(int id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}
	
	public T getBySysId(String sysId) {
		return (T) getHibernateTemplate().get(getEntityClass(), sysId);
	}

	public T loadById(Long id) {
		return (T) getHibernateTemplate().load(getEntityClass(), id);
	}

	public T loadBySysId(String sysId) {
		return (T) getHibernateTemplate().load(getEntityClass(), sysId);
	}
	
	public void save(T t) {
		getHibernateTemplate().save(t);
		getHibernateTemplate().flush();
	}

	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		getHibernateTemplate().flush();
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
		getHibernateTemplate().flush();
	}

	public Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<T> queryAll() {
		DetachedCriteria criteria = createDetachedCriteria();
		return findByCriteria(criteria);
	}

}
