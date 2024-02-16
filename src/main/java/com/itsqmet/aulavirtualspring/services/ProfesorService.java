package com.itsqmet.aulavirtualspring.services;

import com.itsqmet.aulavirtualspring.entities.Estudiante;
import com.itsqmet.aulavirtualspring.entities.Profesor;
import com.itsqmet.aulavirtualspring.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    // GET
    @GetMapping("/getProfesores")
    public List<Profesor> data() {
        // List<Profesor> profesores = profesorRepository.findAll();
        return profesorRepository.findAll();
    }

    // CREAR
    @PostMapping("/postProfesor")
    public Profesor save(@RequestBody Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    // ACTUALIZAR
    @PutMapping("/updateProfesor/{id}")
    public ResponseEntity<Profesor> update(@PathVariable int id, @RequestBody Profesor profesorData) {
        // Buscar por ID
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);

        // Verificar si existe
        if (optionalProfesor.isPresent()) {
            Profesor profesor = optionalProfesor.get();

            // Actualizar los campos con los datos proporcionados
            if (profesorData.getCedula() != null) profesor.setCedula(profesorData.getCedula());
            if (profesorData.getNombres() != null) profesor.setNombres(profesorData.getNombres());
            if (profesorData.getApellidos() != null) profesor.setApellidos(profesorData.getApellidos());

            // Guardar los cambios
            Profesor userSaved = profesorRepository.save(profesor);
            return ResponseEntity.ok(userSaved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR
    @DeleteMapping("/deleteProfesor/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        // Buscar por ID
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);

        // Verificar si existe
        if (optionalProfesor.isPresent()) {
            profesorRepository.delete(optionalProfesor.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
