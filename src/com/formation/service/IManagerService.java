package com.formation.service;

import java.util.List;

public interface IManagerService<T> {

	T add(final T o);
	T update (final T o);
	void delete(final T o);
	List<T> findAll(Class<?> clazz);
	T findById(Class<?> clazz, int id);
}
