package com.demo_vergo.demo_rolando.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;


@Entity
@Table(name="usuarios")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter @Setter
    private Long id_usuario;

    @Getter @Setter
    @NotEmpty(message = "El parametro nombre_usuario es Requerido")
    @Size(min = 4, max = 255, message = "El valor debe ser entre 4 y 255 caracteres")
    private String nombre_usuario;

    @Getter @Setter
    @NotNull(message = "El parametro email_usuario es Requerido")
    @NotEmpty(message = "El parametro email_usuario es Requerido")
    @Size(min = 4, max = 255, message = "El valor debe ser entre 4 y 255 caracteres")
    private String email_usuario;

    @Getter @Setter
    @NotEmpty(message = "El parametro password_usuario es Requerido")
    @Size(min = 4, max = 255, message = "El valor debe ser entre 4 y 255 caracteres")
    private String password_usuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<TareaModel> tareaModelArrayList = new ArrayList<>();


}
