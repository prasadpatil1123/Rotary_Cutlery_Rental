package com.RotaryCutlery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.RotaryCutlery.model.Users;
import com.RotaryCutlery.services.UsersService;

@CrossOrigin("http://localhost:5173/")
@RestController
public class UserController {
	
	@Autowired
	UsersService usersService;
	
//	 @GetMapping("/register")
//	    public String register() {
//	        // Your controller logic here
//	        return "Registration Page";
	        
	@PostMapping("/register")
	public ResponseEntity<Users> register(@RequestBody Users users) {
		 System.out.println("Received a registration request!");
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUsers(users));
		
	}
	
	
	@GetMapping("/login")
	ResponseEntity<Users> login(@RequestParam String email, @RequestParam String password){
		Users users1 = this.usersService.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(users1);
		
	}
	
	@PutMapping("/edituserscreds")
	ResponseEntity<Users> updateUser(@RequestBody Users users){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersService.editUser(users));
	}
	
	
	@GetMapping("/getallusers")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
		
	}
	
	@GetMapping("/user/id/{id}")
	public Users getUserById(@PathVariable int id) {
		return usersService.getUserById(id);
	}
	
	
	@DeleteMapping("/removeuser/id/{id}")
	 Users removeUser(@PathVariable int id) {
		return usersService.deleteUserById(id);
	}
	

}
