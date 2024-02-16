package com.itsqmet.aulavirtualspring.repositories;

import com.itsqmet.aulavirtualspring.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
