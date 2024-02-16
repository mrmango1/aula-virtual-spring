package com.itsqmet.aulavirtualspring.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Calificaciones {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;

    private Double nota;
}
