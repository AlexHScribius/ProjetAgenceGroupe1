package com.formation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.bean.UserBean;
import com.formation.dao.IManagerDao;
import com.formation.util.HibernateUtil;

public class ManagerDao<T> extends HibernateUtil implements IManagerDao<T> {

	@SuppressWarnings("static-access")
	Session hibernateSession = UserBean.getSessionFactory().openSession();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T add(T o) {
		Transaction tr = hibernateSession.beginTransaction();
		T entity = (T) hibernateSession.save(o);
		this.hibernateSession.flush();
		tr.commit();
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(T o) {
		Transaction tr = hibernateSession.beginTransaction();
		T entity = (T) hibernateSession.merge(o);
		this.hibernateSession.flush();
		tr.commit();
		return entity;
	}

	@Override
	public void delete(T o) {
		Transaction tr = hibernateSession.beginTransaction();
		hibernateSession.delete(o);
		hibernateSession.flush();
		tr.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<?> clazz) {
		List<T> liste = hibernateSession.createQuery("from " + clazz.getName()).list();
		return liste;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<?> clazz, Long id) {
		return (T) hibernateSession.get(clazz, id);
	}

	
	
}
