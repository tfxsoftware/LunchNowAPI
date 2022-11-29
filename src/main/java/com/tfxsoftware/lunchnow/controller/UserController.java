package com.tfxsoftware.lunchnow.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.entity.User;
import com.tfxsoftware.lunchnow.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/list")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/update/{user_id}")
	public User updateUser(@RequestBody User user, @PathVariable("user_id") String id) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{user_id}")
	public String deleteUser(@PathVariable("user_id") String id) {
		 userService.deleteUser(id);
		 return "deleted succesfully.";
	}
	
	@GetMapping("/getuser/{user_id}")
	public User getAUser(@PathVariable("user_id") String id){
		return userService.getAUser(id);
	}

	@PostMapping("/authuser")
		public User authentication (@RequestBody Document credentials){
			String email = (String) credentials.get("email");
			String pass = (String) credentials.get("password");
			return userService.userAuth(email, pass);
		}
}
