package com.formation.service.impl;

import java.util.List;

import com.formation.dao.IManagerDao;
import com.formation.dao.impl.ManagerDao;
import com.formation.service.IManagerService;

public class ManagerService<T> implements IManagerService<T> {

	IManagerDao<T> dao = new ManagerDao<T>();
	
	@Override
	public T add(T o) {
		return dao.add(o);
	}

	@Override
	public T update(T o) {
		return dao.update(o);
	}

	@Override
	public void delete(T o) {
		dao.delete(o);
		
	}

	@Override
	public List<T> findAll(Class<?> clazz) {
		return dao.findAll(clazz);
	}

	@Override
	public T findById(Class<?> clazz, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
