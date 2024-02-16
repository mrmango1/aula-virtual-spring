package com.itsqmet.aulavirtualspring.repositories;

import com.itsqmet.aulavirtualspring.entities.Calificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalificacionesRepository extends JpaRepository<Calificaciones, Integer> {

   @Query("SELECT c FROM Calificaciones c WHERE c.curso.id = :idCurso")
    List<Calificaciones> findEstudiantesByCurso(@Param("idCurso") int idCurso);

    @Query("SELECT c FROM Calificaciones c WHERE c.curso.id = :idCurso and c.estudiante.id = :idEstudiante")
    List<Calificaciones> getCalificaciones(@Param("idCurso") int idCurso, @Param("idEstudiante") int idEstudiante);
}
