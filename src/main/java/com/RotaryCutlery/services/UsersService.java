package com.RotaryCutlery.services;

import java.util.List;

import com.RotaryCutlery.model.Users;


public interface UsersService {
	
	
	//POST
	Users addUsers(Users users);
	
	Users login(String email, String password);
	
	Users editUser(Users users);
	
	Users getUserById(int id);
	
	Users deleteUserById(int id);
	
	List<Users> getAllUsers();

}
