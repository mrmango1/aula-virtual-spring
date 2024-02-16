package com.itsqmet.aulavirtualspring.services;

import com.itsqmet.aulavirtualspring.entities.Estudiante;
import com.itsqmet.aulavirtualspring.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    // GET
    @GetMapping("/getEstudiantes")
    public List<Estudiante> data() {
        // List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteRepository.findAll();
    }

    // CREAR
    @PostMapping("/postEstudiante")
    public Estudiante save(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // ACTUALIZAR
    @PutMapping("/updateEstudiante/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable int id, @RequestBody Estudiante estudianteData) {
        // Buscar por ID
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);

        // Verificar si existe
        if (optionalEstudiante.isPresent()) {
            Estudiante estudiante = optionalEstudiante.get();

            // Actualizar los campos con los datos proporcionados
            if (estudianteData.getCedula() != null) estudiante.setCedula(estudianteData.getCedula());
            if (estudianteData.getNombres() != null) estudiante.setNombres(estudianteData.getNombres());
            if (estudianteData.getApellidos() != null) estudiante.setApellidos(estudianteData.getApellidos());

            // Guardar los cambios
            Estudiante userSaved = estudianteRepository.save(estudiante);
            return ResponseEntity.ok(userSaved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR
    @DeleteMapping("/deleteEstudiante/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        // Buscar por ID
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);

        // Verificar si existe
        if (optionalEstudiante.isPresent()) {
            estudianteRepository.delete(optionalEstudiante.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
