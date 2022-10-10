package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

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
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User userEntity = findById.get();
			if (user.getName() != null && !user.getName().isEmpty())
				userEntity.setName(user.getName());
			if (user.getEmail() != null && !user.getEmail().isEmpty())
				userEntity.setEmail(user.getEmail());
			if (user.getPassword() != null && !user.getPassword().isEmpty())
				userEntity.setPassword(user.getPassword());
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public User getAUser(long id){
		Optional<User> findById = userRepository.findById(id);
		return findById.get();
	}
}
