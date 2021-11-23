package com.kv.util;

public class SQLCommand {
	public static final String FIND_BY_USERNAME_AND_PASSWORD = "Select*From user where user_name = ? And password = ? ";

	public static final String FIND_ALL_PRODUCT = "Select*From Product";

	public static final String ADD_PRODUCT = "Insert into Product(`name`,`price`,`description`)Values(?,?,?)";

	public static final String FIND_PRODUCT_BY_ID = "Select * from Product Where id = ?";

	public static final String UPDATE_PRODUCT = "Update product Set `name` = ? , price = ?, description = ? Where id = ? ";

	public static final String DELETE_PRODUCT_BY_ID = "Delete From product Where id = ?";

	public static final String FIND_PRODUCT_BY_NAME = "Select * From product Where name Like ?";

}
