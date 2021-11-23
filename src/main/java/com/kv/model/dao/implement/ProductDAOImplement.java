package com.kv.model.dao.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kv.model.dao.ProductDAO;
import com.kv.model.entity.Product;
import com.kv.util.DBUtil;
import com.kv.util.SQLCommand;

public class ProductDAOImplement implements ProductDAO {

	private DBUtil database;

	public ProductDAOImplement() {
		database = DBUtil.getInstance();

	}

	@Override
	public List<Product> findAll() {
		List<Product> result = null;

		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.FIND_ALL_PRODUCT);
			ResultSet rs = ps.executeQuery();
			result = new ArrayList<Product>();
			Product p = null;
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setDescription(rs.getString(4));
				result.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean add(Product entity) {
		int result = 0;
		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.ADD_PRODUCT);
			ps.setString(1, entity.getName());
			ps.setFloat(2, entity.getPrice());
			ps.setString(3, entity.getDescription());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}

	@Override
	public Product findById(Integer id) {
		Product result = null;

		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.FIND_PRODUCT_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = new Product();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setPrice(rs.getFloat(3));
				result.setDescription(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean update(Product entity) {
		boolean result = false;
		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.UPDATE_PRODUCT);
			ps.setString(1, entity.getName());
			ps.setFloat(2, entity.getPrice());
			ps.setString(3, entity.getDescription());
			ps.setInt(4, entity.getId());

			int count = ps.executeUpdate();
			if (count == 1) {
				result = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteById(Integer id) {

		boolean result = false;
		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.DELETE_PRODUCT_BY_ID);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count == 1) {
				result = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Product> findByProductName(String keyword) {
		List<Product> result = null;

		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.FIND_PRODUCT_BY_NAME);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			result = new ArrayList<Product>();
			Product p = null;
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setDescription(rs.getString(4));
				result.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
