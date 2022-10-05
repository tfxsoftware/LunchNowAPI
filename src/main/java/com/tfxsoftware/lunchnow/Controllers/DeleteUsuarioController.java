package com.tfxsoftware.lunchnow.Controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.Servicos;
import com.tfxsoftware.lunchnow.Models.Usuario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("deletaUsuario")
@AllArgsConstructor

public class DeleteUsuarioController {
    private final Servicos servicoUsuario;
    
    @GetMapping
    public String verificarEDeletarUsuario(){
        String nome = "teste";
        String email = "teste@gmail.com";
        String senha = "password";
        Usuario novousuario = new Usuario(
            nome,
            email,
            senha,
            LocalDateTime.now()
        );
        
        
        
        if(servicoUsuario.verificarEDeletar(novousuario)) return "Usuario deletado com sucesso!";
        else return "Email não existente!";
    }
}
