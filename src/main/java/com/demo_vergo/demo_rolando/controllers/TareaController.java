package com.demo_vergo.demo_rolando.controllers;


import com.demo_vergo.demo_rolando.models.TareaModel;
import com.demo_vergo.demo_rolando.services.TareaService;
import com.demo_vergo.demo_rolando.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TareaController {
    @Autowired
    TareaService tareaService;
    @Autowired
    private JWTUtil jwtUtil;


    @GetMapping()
    public ArrayList<TareaModel> obtenerTareas( @RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        return tareaService.obtenerTareas();
    }

    @GetMapping(path = "/{id}")
    public Optional<TareaModel> obtenerTareaId(@PathVariable("id") Long id,@RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        return tareaService.obtenerTareaId(id);
    }

    @PostMapping()
    public TareaModel guardarTarea(@RequestBody TareaModel tarea,@RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        return tareaService.guardarTarea(tarea);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id,@RequestHeader(value = "Authorization") String token){
        if (!jwtUtil.validarToken(token)){return null;}
        boolean status = tareaService.eliminarTarea(id);
        if(status){
            return "Se elimino el usuario con id: "+id;
        }else{
            return "Error al eliminar el usuario con id: "+id;
        }
    }
}










