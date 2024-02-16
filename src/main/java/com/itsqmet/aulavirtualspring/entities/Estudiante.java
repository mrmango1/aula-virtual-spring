package com.itsqmet.aulavirtualspring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;

}
