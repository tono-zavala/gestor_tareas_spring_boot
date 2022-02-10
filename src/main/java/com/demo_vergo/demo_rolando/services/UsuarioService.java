package com.demo_vergo.demo_rolando.services;

import com.demo_vergo.demo_rolando.models.UsuarioModel;
import com.demo_vergo.demo_rolando.repositories.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario( UsuarioModel usuario){return usuarioRepository.save(usuario);}

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            System.out.println(err);
            return false;
        }
    }


    public UsuarioModel obtenerUsuarioPorCredenciales(UsuarioModel usuario) {
        return obtenerUsuarioPorCredenciales(usuario);
    }
}
