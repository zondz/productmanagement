package com.kv.model.dao.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kv.model.dao.UserDAO;
import com.kv.model.entity.User;
import com.kv.util.DBUtil;
import com.kv.util.SQLCommand;

public class UserDAOImplement implements UserDAO {

	private DBUtil database;

	public UserDAOImplement() {
		database = DBUtil.getInstance();
	}

	@Override
	public User findByUserNameAndPassword(User user) {
		User result = null;
		try {
			PreparedStatement ps = database.connection.prepareStatement(SQLCommand.FIND_BY_USERNAME_AND_PASSWORD);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = new User();
				int id = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				result.setId(id);
				result.setUserName(userName);
				result.setPassword(password);
				result.setName(name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
