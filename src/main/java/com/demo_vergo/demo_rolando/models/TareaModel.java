package com.demo_vergo.demo_rolando.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tareas")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter @Setter
    private Long id_tarea;

    @Getter @Setter
    @NotEmpty(message = "El parametro titulo_area es Requerido")
    @Size(min = 4, max = 255, message = "El valor debe ser entre 4 y 255 caracteres")
    private String titulo_tarea;

    @Getter @Setter
    @NotEmpty(message = "El parametro descripcion_tarea es Requerido")
    @Size(min = 4, max = 255, message = "El valor debe ser entre 4 y 255 caracteres")
    private String descripcion_tarea;


    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn (name="user",referencedColumnName="id_usuario",nullable=true,unique=true)
    private UsuarioModel usuario;

    @Getter @Setter
    private String msg;

}
