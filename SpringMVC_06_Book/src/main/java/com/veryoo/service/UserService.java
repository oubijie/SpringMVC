package com.veryoo.service;

import com.veryoo.entity.User;

public interface UserService {

	User getUserById(Integer id);
	User getUserByUsername(String username);
}
