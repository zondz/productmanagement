package com.kv.model.service;

public interface Service<E, I> {

	boolean add(E entity);

	E findById(I id);

	boolean update(E entity);

	boolean deleteById(I id);
}
