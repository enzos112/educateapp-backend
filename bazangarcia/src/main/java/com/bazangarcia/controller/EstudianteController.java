package com.bazangarcia.controller;

import com.bazangarcia.model.Estudiante;
import com.bazangarcia.service.implementation.EstudianteService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/estudiantes")
    public Estudiante crear (@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> buscartodo (){
        return estudianteService.findAll();
    }

    @GetMapping("/estudiantes/{id}")
    public Estudiante buscarxid (@PathVariable Integer id){
        return estudianteService.findById(id);
    }

    @PutMapping ("/estudiantes/{id}")
    public Estudiante actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante){
        return estudianteService.update(id, estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public String eliminar(@PathVariable Integer id) {  // ← Aquí el cambio
        estudianteService.deleteById(id);
        return "Estudiante eliminado exitosamente";
    }

}
