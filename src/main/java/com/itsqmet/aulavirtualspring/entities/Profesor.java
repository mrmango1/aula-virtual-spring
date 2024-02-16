package com.itsqmet.aulavirtualspring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
}
