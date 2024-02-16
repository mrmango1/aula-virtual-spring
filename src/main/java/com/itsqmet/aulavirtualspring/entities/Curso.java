package com.itsqmet.aulavirtualspring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombreCurso;

    // Profesor
    @OneToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private Profesor profesor;

    // Estudiantes
    // @ManyToOne
    // @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    // private Estudiante estudiante;

    // Calificaciones
//    @OneToMany(mappedBy = "curso")
//    private List<Calificaciones> calificaciones;
}
