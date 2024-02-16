package com.itsqmet.aulavirtualspring.repositories;

import com.itsqmet.aulavirtualspring.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
