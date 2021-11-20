package com.kv.model.service.implement;

import java.util.List;

import com.kv.model.dao.ProductDAO;
import com.kv.model.dao.implement.ProductDAOImplement;
import com.kv.model.entity.Product;
import com.kv.model.service.ProductService;

public class ProductServiceImplement implements ProductService {
	private ProductDAO productDAO;

	public ProductServiceImplement() {
		// TODO Auto-generated constructor stub
		productDAO = new ProductDAOImplement();
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

}
