package com.kv.model.dao;

import com.kv.model.entity.User;

public interface UserDAO {

	User findByUserNameAndPassword(User user);
}
