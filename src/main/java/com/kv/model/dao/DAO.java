package com.kv.model.dao;

public interface DAO<E, I> {
	boolean add(E entity);

	E findById(I id);

	boolean update(E entity);

	boolean deleteById(I id);
}
