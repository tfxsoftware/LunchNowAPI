package com.tfxsoftware.lunchnow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

}
