package com.RotaryCutlery.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RotaryCutlery.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer>  {

	Users findByEmailAndPassword(String email, String password);

//	Users saveAll(Object foundUser);

//	Users saveAll(Optional<Users> foundUser);

}
