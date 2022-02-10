package com.demo_vergo.demo_rolando.controllers;

import com.demo_vergo.demo_rolando.models.UsuarioModel;
import com.demo_vergo.demo_rolando.services.UsuarioService;
import com.demo_vergo.demo_rolando.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(@RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        return usuarioService.obtenerUsuarios();
    }
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id, @RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        return this.usuarioService.obtenerPorId(id);
    }


    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1,usuario.getPassword_usuario());
        usuario.setPassword_usuario(hash);
        return this.usuarioService.guardarUsuario(usuario);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id, @RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        boolean status = usuarioService.eliminarUsuario(id);
        if(status){
            return "Se elimino el usuario con id: "+id;
        }else{
            return "Error al eliminar el usuario con id: "+id;
        }
    }


}
