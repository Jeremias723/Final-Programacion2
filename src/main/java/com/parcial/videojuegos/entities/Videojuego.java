package com.parcial.videojuegos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity // Significa que cuando arranque el proyecto, esta clase se mapea en la db como una tabla
@Table(name = "videojuegos") // Sobreescribe el nombre de la tabla
@Getter //
@Setter // Genera metodos
@AllArgsConstructor //Genera los constructores
@NoArgsConstructor
public class Videojuego {

    //Propiedades

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El titulo no puede estar vacio")
    private String titulo;
    @Size(min=5,max=200,message= "La descripcion debe ser entre 5 y 200 caracteres")
    private String descripcion;

    private String imagen;

    @Min(value = 5,message="El precio debe tener un minimo de 5")
    @Max(value = 10000, message="El precio debe ser menor a 1000")
    private float precio;
    @Min(value = 1,message="El stock debe tener un minimo de 5")
    @Max(value = 10000, message="El stock debe ser menor a 1000")
    private short stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="La fecha no puede ser nula")
    @PastOrPresent(message="Debe ser igual o menor a la fecha de hoy")
    private Date fechaLanzamiento;
    private boolean activo = true;


    @NotNull(message="Es requerido el estudio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_estudio", nullable = false)
    private Estudio estudio;


    @NotNull(message="Es requerida la categoria")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoria;
}
