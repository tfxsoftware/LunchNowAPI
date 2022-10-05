package com.tfxsoftware.lunchnow.Controllers;



import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.Servicos;
import com.tfxsoftware.lunchnow.Models.Usuario;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/cadastroUsuario")
@AllArgsConstructor
public class CadastrarUsuarioController {
    
    private final Servicos servicoUsuario;
    
    @GetMapping
    public String verificarECadastrar(){
        String nome = "teste";
        String email = "teste@gmail.com";
        String senha = "password";
        Usuario novousuario = new Usuario(
            nome,
            email,
            senha,
            LocalDateTime.now()
        );

        if(servicoUsuario.verificarECadastrar(novousuario)) return "Usuario cadastrado com sucesso!";
        else return "Email ja cadastrado!";
    }
}