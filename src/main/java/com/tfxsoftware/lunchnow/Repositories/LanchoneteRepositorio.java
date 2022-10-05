package com.tfxsoftware.lunchnow.Repositories;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.Models.Lanchonete;


public interface LanchoneteRepositorio extends MongoRepository<Lanchonete, String>{
    
    Optional<Lanchonete> findLanchoneteByEmail(String email);
    void deleteByEmail(String email);

    
}