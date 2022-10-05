package com.tfxsoftware.lunchnow.Models;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Usuario {
    @Id
    private String id;
    private String nome;
    @Indexed(unique = true)
    private String email;
    private String senha;
    private LocalDateTime datacriacao;
    
    
    public Usuario(String nome, String email, String senha, LocalDateTime datacriacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.datacriacao = datacriacao;
    }
}
