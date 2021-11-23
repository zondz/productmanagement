package com.kv.model.dao;

import java.util.List;

import com.kv.model.entity.Product;

public interface ProductDAO extends DAO<Product, Integer> {

	List<Product> findAll();

	List<Product> findByProductName(String keyword);
}
