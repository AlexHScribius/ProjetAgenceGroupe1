package com.formation.dao;

import java.util.List;

public interface IManagerDao<T> {

	T add(final T o);
	T update (final T o);
	void delete(final T o);
	List<T> findAll(Class<?> clazz);
	T findById(Class<?> clazz, Long id);
}
