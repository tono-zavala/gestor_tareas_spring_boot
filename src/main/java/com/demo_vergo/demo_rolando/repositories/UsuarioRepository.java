package com.demo_vergo.demo_rolando.repositories;

import com.demo_vergo.demo_rolando.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
//    public abstract ArrayList<UsuarioModel> findByNombre_Usuario(String nombre_usuario);
//    UsuarioModel obtenerUsuarioPorCredenciales(UsuarioModel usuario);
}
