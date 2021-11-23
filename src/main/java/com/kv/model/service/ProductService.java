package com.kv.model.service;

import java.util.List;

import com.kv.model.entity.Product;

public interface ProductService extends Service<Product, Integer> {

	List<Product> findAll();

	List<Product> findByProductName(String keyword);

}
