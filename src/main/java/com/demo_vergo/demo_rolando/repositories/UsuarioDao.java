package com.demo_vergo.demo_rolando.repositories;


import com.demo_vergo.demo_rolando.models.UsuarioModel;

import java.util.List;

public interface UsuarioDao {

        List<UsuarioModel> getUsuarios();


        void eliminar(Long id);

        void registrar(UsuarioModel usuario);

        UsuarioModel obtenerUsuarioPorCredenciales(UsuarioModel usuario);
    }
