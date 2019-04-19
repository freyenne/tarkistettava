package com.example.harjoitustyo2019.service;



import com.example.harjoitustyo2019.model.User;


public interface UserService {
	void save(User user);
	
	User findByUsername(String username);

}
