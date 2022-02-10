package com.demo_vergo.demo_rolando.repositories;

import com.demo_vergo.demo_rolando.models.TareaModel;
import com.demo_vergo.demo_rolando.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<TareaModel, Long > {
    public abstract Long countByUsuario (UsuarioModel usuario);
}

