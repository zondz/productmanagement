package com.kv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/productdb";
	private static final String USER = "root";
	private static final String PASSWORD = "123456789";
	public Connection connection;
	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		connection = getJDBCConnection();
	}

	public static Connection getJDBCConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static DBUtil getInstance() {
		return instance;

	}

}
