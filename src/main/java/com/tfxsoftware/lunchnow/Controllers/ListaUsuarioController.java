package com.tfxsoftware.lunchnow.Controllers;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.Servicos;
import com.tfxsoftware.lunchnow.Models.Usuario;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("listausuarios")
@AllArgsConstructor
public class ListaUsuarioController {
    
    private final Servicos servicoUsuario;
    @GetMapping
    public List<Usuario> fetchAllUsuarios(){
        return servicoUsuario.getAllUsuarios();
    }
}
