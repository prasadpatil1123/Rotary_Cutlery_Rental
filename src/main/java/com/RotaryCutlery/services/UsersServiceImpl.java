package com.RotaryCutlery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.RotaryCutlery.dao.UsersDao;
import com.RotaryCutlery.exception.ResourceNotFoundException;
import com.RotaryCutlery.model.Users;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;
	
	@Override
	public Users addUsers(Users users) {
		System.out.println(users);
		Users savedUser = usersDao.save(users);
		return savedUser;
	}

	@Override
	public Users login(String email, String password) {
		return usersDao.findByEmailAndPassword(email, password);
	}

	@Override
	public Users editUser(Users users) {
	Users foundUser = usersDao.findById(users.getId()).orElseThrow(()-> new RuntimeException("User Not found !!"));

		foundUser.setFirstName(users.getFirstName());
		foundUser.setLastName(users.getLastName());
		foundUser.setMobileNo(users.getMobileNo());
		foundUser.setEmail(users.getEmail());
		foundUser.setPassword(users.getPassword());
		foundUser.setUserRole(users.getUserRole());
		
		return usersDao.save(foundUser);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return usersDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
	}

	@Override
	public Users deleteUserById(int id) {
		// TODO Auto-generated method stub
		usersDao.deleteById(id);
		return null;
	}

	@Override
	public List<Users> getAllUsers() {
		return usersDao.findAll();
	}



}
