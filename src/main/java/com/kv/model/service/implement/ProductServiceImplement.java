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

	@Override
	public boolean add(Product entity) {

		return productDAO.add(entity);
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id);
	}

	@Override
	public boolean update(Product entity) {
		// TODO Auto-generated method stub
		return productDAO.update(entity);
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.deleteById(id);
	}

	@Override
	public List<Product> findByProductName(String keyword) {
		// TODO Auto-generated method stub
		return productDAO.findByProductName(keyword);
	}

}
