package com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.User;
import com.test.repositories.UserRepo;
@Service
public class UserServiceImplementation implements UserService {
	@Autowired 
	UserRepo repo;
	@Override
	public void addData(User user) {
		// TODO Auto-generated method stub
		 repo.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=repo.findAll();
		return users;
	}
	@Override
	public User getSpecificUser(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
		
	}
	@Override
	public User getUsername(String loginuser) {
		// TODO Auto-generated method stub
		return repo.findByUsername(loginuser);
	}
	@Override
	public boolean acceptReq() {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public User getUser(String loginuser) {
		// TODO Auto-generated method stub
		repo.findByUsername(loginuser);
		return null;
	}
	
}
