package com.kv.model.service.implement;

import com.kv.model.dao.UserDAO;
import com.kv.model.dao.implement.UserDAOImplement;
import com.kv.model.entity.User;
import com.kv.model.service.UserService;

public class UserServiceImplement implements UserService {
	private UserDAO userDAO;

	public UserServiceImplement() {
		userDAO = new UserDAOImplement();
	}

	@Override
	public User checkLogin(User user) {
		User result = userDAO.findByUserNameAndPassword(user);
		return result;

	}

}
