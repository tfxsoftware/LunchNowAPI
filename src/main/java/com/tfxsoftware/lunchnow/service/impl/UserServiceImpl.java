package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.entity.User;
import com.tfxsoftware.lunchnow.repository.UserRepository;
import com.tfxsoftware.lunchnow.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		List<User> list = userRepository.findAll();
		Iterator<User> cursor = list.iterator();

		while (cursor.hasNext()){
			User current = cursor.next();
			if (current.getEmail().equals(user.getEmail()) || current.getCpf().equals(user.getCpf())) return null;	
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(String id, User user) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User userEntity = findById.get();
			if (user.getName() != null && !user.getName().isEmpty())
				userEntity.setName(user.getName());
			if (user.getEmail() != null && !user.getEmail().isEmpty())
				userEntity.setEmail(user.getEmail());
			if (user.getPassword() != null && !user.getPassword().isEmpty())
				userEntity.setPassword(user.getPassword());
			if (user.getUserImgUrl() != null && !user.getUserImgUrl().isEmpty())
				userEntity.setUserImgUrl(user.getUserImgUrl());
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	public User getAUser(String id){
		Optional<User> findById = userRepository.findById(id);
		return findById.get();
	}

	public User userAuth(String email, String pass){
		List<User> list = userRepository.findAll();
		Iterator<User> cursor = list.iterator();

		while (cursor.hasNext()){
			User current = cursor.next();
			if (current.getEmail().equals(email) && current.getPassword().equals(pass)) return current;	
		}
		return null;
	}
}
