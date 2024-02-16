package com.itsqmet.aulavirtualspring.services;

import com.itsqmet.aulavirtualspring.entities.Curso;
import com.itsqmet.aulavirtualspring.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    // GET
    @GetMapping("/getCursos")
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    // CREAR
    @PostMapping("/postCurso")
    public Curso saveCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    // ACTUALIZAR
    @PutMapping("/updateCurso/{id}")
    public ResponseEntity<Curso> update(@PathVariable int id, @RequestBody Curso cursoData) {
        // Buscar por ID
        Optional<Curso> optionalCurso = cursoRepository.findById(id);

        // Verificar si existe
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();

            // Actualizar los campos con los datos proporcionados
            if (cursoData.getNombreCurso() != null) curso.setNombreCurso(cursoData.getNombreCurso());
            if (cursoData.getProfesor() != null) curso.setProfesor(cursoData.getProfesor());
            if (cursoData.getEstudiante() != null) curso.setEstudiante(cursoData.getEstudiante());

            // Guardar los cambios
            Curso userSaved = cursoRepository.save(curso);
            return ResponseEntity.ok(userSaved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR
    @DeleteMapping("/deleteCurso/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        // Buscar por ID
        Optional<Curso> optionalCurso = cursoRepository.findById(id);

        // Verificar si existe
        if (optionalCurso.isPresent()) {
            cursoRepository.delete(optionalCurso.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
