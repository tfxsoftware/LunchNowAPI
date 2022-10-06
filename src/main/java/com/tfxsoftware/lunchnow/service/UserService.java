package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getUsers();

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);
}
