package com.jwtApi.api.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtApi.api.entity.User;
import com.jwtApi.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users = new ArrayList<User>();
	
	@Override
	public User findByEmail(String email) {

		for (User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		
		return null;
		
	}

	@Override
	public User createOrUpdate(User user) {
		
		users.add(user);
		return user;
		
	}

	@Override
	public User findById(String id) {
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
		
	}

	@Override
	public void delete(String id) {
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId()==id) {
				users.remove(i);
			}
		}
		
	}

	@Override
	public List<User> findAll() {

		return users;
	}

}
