package com.test.services;

import java.util.List;

import com.test.entities.User;

public interface UserService {

	void addData(User user);

	List<User> getAllUsers();

	User getSpecificUser(Long id);

	User getUsername(String loginuser);

	boolean acceptReq();

	User getUser(String loginuser);

}
