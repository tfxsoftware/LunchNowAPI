package com.tfxsoftware.lunchnow.Repositories;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.Models.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
    
    Optional<Usuario> findUsuarioByEmail(String email);
    void deleteByEmail(String email);

    
}
