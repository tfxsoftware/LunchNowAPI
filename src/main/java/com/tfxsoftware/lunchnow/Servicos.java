package com.tfxsoftware.lunchnow;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.Models.Lanchonete;
import com.tfxsoftware.lunchnow.Models.Usuario;
import com.tfxsoftware.lunchnow.Repositories.LanchoneteRepositorio;
import com.tfxsoftware.lunchnow.Repositories.UsuarioRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class Servicos {
    
    final UsuarioRepositorio usuarioRepositorio;
    final LanchoneteRepositorio lanchoneteRepositorio;
    
    
    public List<Usuario> getAllUsuarios(){
        return usuarioRepositorio.findAll();
    }
    
    public boolean verificarECadastrar(Usuario usuario){
        String email = usuario.getEmail();

        if (usuarioRepositorio.findUsuarioByEmail(email).isPresent()){
            return false;
        }
        else {
            usuarioRepositorio.save(usuario);
            return true;
        }
 
    }

    public boolean verificarEDeletar(Usuario usuario){
        String email = usuario.getEmail();
        if (usuarioRepositorio.findUsuarioByEmail(email).isPresent()){
            usuarioRepositorio.deleteByEmail(email);
            return true;
        }
        else {
            
            return false;
        }
    }



 

}
