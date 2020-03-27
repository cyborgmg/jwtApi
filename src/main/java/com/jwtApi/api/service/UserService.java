package com.jwtApi.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jwtApi.api.entity.User;

public interface UserService {
	
	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(String id);
	
	void delete(String id);

	List<User> findAll();

}
