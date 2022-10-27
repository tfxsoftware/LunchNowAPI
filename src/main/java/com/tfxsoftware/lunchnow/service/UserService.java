package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getUsers();

	public User updateUser(String id, User user);

	public void deleteUser(String id);

	public User getAUser(String id);

	public User userAuth(String email, String pass);

	
}
