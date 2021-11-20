package com.kv.model.dao;

import java.util.List;

import com.kv.model.entity.Product;

public interface ProductDAO {

	List<Product> findAll();
}
