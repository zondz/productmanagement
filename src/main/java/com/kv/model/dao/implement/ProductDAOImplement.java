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

}
