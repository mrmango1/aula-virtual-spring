package com.itsqmet.aulavirtualspring.services;

import com.itsqmet.aulavirtualspring.entities.Calificaciones;
import com.itsqmet.aulavirtualspring.entities.Curso;
import com.itsqmet.aulavirtualspring.repositories.CalificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CalificacionesService {

    @Autowired
    CalificacionesRepository calificacionesRepository;

    // GET
    @GetMapping("/getAllCalificaciones")
    public List<Calificaciones> getCalificaciones() {
        return calificacionesRepository.findAll();
    }

    // GET
    @PostMapping("/getEstudiantesByCurso")
    public List<Calificaciones> getEstudiantesByCurso(@RequestBody Curso curso) {
        System.out.println(curso);
        return calificacionesRepository.findEstudiantesByCurso(curso.getId());
    }

    // GET
    @PostMapping("/getCalificaciones")
    public List<Calificaciones> getCalificacionesByCurso(@RequestBody Calificaciones calificaciones) {
        System.out.println(calificaciones);
        int idCurso = calificaciones.getCurso().getId();
        int idEstudiante = calificaciones.getEstudiante().getId();
        return calificacionesRepository.getCalificaciones(idCurso, idEstudiante);
    }

    // CREAR
    @PostMapping("/postCalificacion")
    public Calificaciones saveCalificacion(@RequestBody Calificaciones calificaciones) {
        return calificacionesRepository.save(calificaciones);
    }

    // ACTUALIZAR
    @PutMapping("/updateCalificacion/{id}")
    public ResponseEntity<Calificaciones> update(@PathVariable int id, @RequestBody Calificaciones CalificacionData) {
        // Buscar por ID
        Optional<Calificaciones> optionalCalificaciones = calificacionesRepository.findById(id);

        // Verificar si existe
        if (optionalCalificaciones.isPresent()) {
            Calificaciones calificaciones = optionalCalificaciones.get();

            // Actualizar los campos con los datos proporcionados
            if (CalificacionData.getCurso() != null) calificaciones.setCurso(CalificacionData.getCurso());
            if (CalificacionData.getEstudiante() != null) calificaciones.setEstudiante(CalificacionData.getEstudiante());
            if (CalificacionData.getNota() != null) calificaciones.setNota(CalificacionData.getNota());

            // Guardar los cambios
            Calificaciones userSaved = calificacionesRepository.save(calificaciones);
            return ResponseEntity.ok(userSaved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR
    @DeleteMapping("/deleteCalificacion/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        // Buscar por ID
        Optional<Calificaciones> optionalCalificaciones = calificacionesRepository.findById(id);

        // Verificar si existe
        if (optionalCalificaciones.isPresent()) {
            calificacionesRepository.delete(optionalCalificaciones.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
