package com.demo_vergo.demo_rolando.services;

import com.demo_vergo.demo_rolando.models.TareaModel;
import com.demo_vergo.demo_rolando.models.UsuarioModel;
import com.demo_vergo.demo_rolando.repositories.TareaRepository;
import com.demo_vergo.demo_rolando.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    @Value("${carga_de_tareas}")
    private Integer cargaTareas;

    public ArrayList<TareaModel> obtenerTareas(){
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    public TareaModel guardarTarea(TareaModel tarea){
        System.out.println((tarea.getUsuario().getId_usuario()));
        UsuarioModel usuario = usuarioRepository.getById(tarea.getUsuario().getId_usuario());
        tarea.setUsuario(usuario);
        Long numTareasAsignadas = tareaRepository.countByUsuario(usuario);
        System.out.println(numTareasAsignadas);
        if(numTareasAsignadas<cargaTareas){
            return tareaRepository.save(tarea);
        }else{
            TareaModel mensaje = new TareaModel();
            mensaje.setMsg("Error! No se puede ingresar mas de 5 Tareas a un Usuario");
            return mensaje;
        }

    }

    public Optional<TareaModel> obtenerTareaId(Long id){return  tareaRepository.findById(id);}

    public boolean eliminarTarea(Long id){
        try {
            tareaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            System.out.println(err);
            return false;
        }
    }
}








