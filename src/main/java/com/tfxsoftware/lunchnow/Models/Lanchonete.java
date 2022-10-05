package com.tfxsoftware.lunchnow.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Lanchonete {

    @Id
    private String id;
    private String nome;
    private String local;
    private List<String> cardapio;
    @Indexed(unique = true)
    private String email;
    private String senha;

    public Lanchonete(String nome, String culinaria, List<String> cardapio, String email, String senha) {
        this.nome = nome;
        this.local = culinaria;
        this.cardapio = cardapio;
        this.email = email;
        this.senha = senha;
    }

    

}
