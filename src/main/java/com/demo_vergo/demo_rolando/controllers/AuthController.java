package com.demo_vergo.demo_rolando.controllers;
import com.demo_vergo.demo_rolando.models.UsuarioModel;
import com.demo_vergo.demo_rolando.repositories.UsuarioDao;
import com.demo_vergo.demo_rolando.repositories.UsuarioRepository;
import com.demo_vergo.demo_rolando.services.UsuarioService;
import com.demo_vergo.demo_rolando.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody UsuarioModel usuario){

        UsuarioModel usuarioLoggeado = usuarioRepository.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLoggeado !=null){

            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLoggeado.getId_usuario() ), usuarioLoggeado.getEmail_usuario());
            System.out.println(tokenJWT);
            return tokenJWT;
        }
        return "Fail";
    }

}
