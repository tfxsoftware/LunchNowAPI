package com.tfxsoftware.lunchnow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.entity.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

}
