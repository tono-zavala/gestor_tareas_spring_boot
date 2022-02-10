package com.demo_vergo.demo_rolando.repositories;

import com.demo_vergo.demo_rolando.models.UsuarioModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuarioModel> getUsuarios() {
        String query = "FROM Usuario";
        List<UsuarioModel> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        UsuarioModel usuario = entityManager.find(UsuarioModel.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(UsuarioModel usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public UsuarioModel obtenerUsuarioPorCredenciales(UsuarioModel usuario){
        String query = "FROM UsuarioModel WHERE email_usuario= :email";
        List<UsuarioModel> lista = entityManager.createQuery(query).setParameter("email", usuario.getEmail_usuario()).getResultList();
        if(lista.isEmpty()){
            return null;
        }
        String passwordHashed = lista.get(0).getPassword_usuario();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, usuario.getPassword_usuario())){
            return lista.get(0);
        }
        return null;
    }

}
